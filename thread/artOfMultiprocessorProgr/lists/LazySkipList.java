package thread.artOfMultiprocessorProgr.lists;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: webserg
 * Date: 03.01.12
 */
public class LazySkipList<T> {
    /**
     * Seed for simple random number generator.  Not volatile since it
     * doesn't matter too much if different threads don't see updates.
     */
    private transient int randomSeed;
    /**
     * Generates the initial random seed for the cheaper per-instance
     * random number generators used in randomLevel.
     */
    private static final Random seedGenerator = new Random();

    static final int MAX_LEVEL = 5;
    final Node<T> head = new Node<T>(Integer.MIN_VALUE);
    final Node<T> tail = new Node<T>(Integer.MAX_VALUE);

    public LazySkipList() {
        randomSeed = seedGenerator.nextInt() | 0x0100; // ensure nonzero;
        for (int i = 0; i < head.next.length; i++) {
            head.next[i] = tail;
        }
    }

    /**
     * @param x
     * @param preds
     * @param succs
     * @return
     */
    int find(T x, Node<T>[] preds, Node<T>[] succs) {
        int key = x.hashCode();
        int lFound = -1;
        Node<T> pred = head;
        for (int level = MAX_LEVEL; level >= 0; level--) {
            Node<T> curr = pred.next[level];
            while (key > curr.key) {
                pred = curr;
                curr = pred.next[level];
            }
            if (lFound == -1 && key == curr.key) {
                lFound = level;
            }
            preds[level] = pred;
            succs[level] = curr;
        }
        return lFound;
    }

    boolean add(T x) {
        int topLevel = randomLevel();
        Node<T>[] preds = (Node<T>[]) new Node[MAX_LEVEL + 1];
        Node<T>[] succs = (Node<T>[]) new Node[MAX_LEVEL + 1];
        while (true) {
            int lFound = find(x, preds, succs);
            if (lFound != -1) {
                Node<T> nodeFound = succs[lFound];
                if (!nodeFound.marked) {
                    while (!nodeFound.fullyLinked) {
                    }
                    return false;
                }
                continue;
            }
            int highestLocked = -1;
            try {
                Node<T> pred, succ;
                boolean valid = true;
                for (int level = 0; valid && (level <= topLevel); level++) {
                    pred = preds[level];
                    succ = succs[level];
                    pred.lock.lock();
                    highestLocked = level;
                    valid = !pred.marked && !succ.marked && pred.next[level] == succ;
                }
                if (!valid) continue;
                Node<T> newNode = new Node(x, topLevel);
                for (int level = 0; level <= topLevel; level++)
                    newNode.next[level] = succs[level];
                for (int level = 0; level <= topLevel; level++)
                    preds[level].next[level] = newNode;
                newNode.fullyLinked = true; // successful add linearization point
                return true;
            } finally {
                for (int level = 0; level <= highestLocked; level++)
                    preds[level].unlock();
            }
        }
    }

    boolean remove(T x) {
        Node<T> victim = null;
        boolean isMarked = false;
        int topLevel = -1;
        Node<T>[] preds = (Node<T>[]) new Node[MAX_LEVEL + 1];
        Node<T>[] succs = (Node<T>[]) new Node[MAX_LEVEL + 1];
        while (true) {
            int lFound = find(x, preds, succs);
            if (lFound != -1) victim = succs[lFound];
            if (isMarked |
                    (lFound != -1 &&
                            (victim.fullyLinked
                                    && victim.topLevel == lFound
                                    && !victim.marked))) {
                if (!isMarked) {
                    topLevel = victim.topLevel;
                    victim.lock.lock();
                    if (victim.marked) {
                        victim.lock.unlock();
                        return false;
                    }
                    victim.marked = true;
                    isMarked = true;
                }
                int highestLocked = -1;
                try {
                    Node<T> pred, succ;
                    boolean valid = true;
                    for (int level = 0; valid && (level <= topLevel); level++) {
                        pred = preds[level];
                        pred.lock.lock();
                        highestLocked = level;
                        valid = !pred.marked && pred.next[level] == victim;
                    }
                    if (!valid) continue;
                    for (int level = topLevel; level >= 0; level--) {
                        preds[level].next[level] = victim.next[level];
                    }
                    victim.lock.unlock();
                    return true;
                } finally {
                    for (int i = 0; i <= highestLocked; i++) {
                        preds[i].unlock();
                    }
                }
            } else return false;
        }
    }

    boolean contains(T x) {
        Node<T>[] preds = (Node<T>[]) new Node[MAX_LEVEL + 1];
        Node<T>[] succs = (Node<T>[]) new Node[MAX_LEVEL + 1];
        int lFound = find(x, preds, succs);
        return (lFound != -1
                && succs[lFound].fullyLinked
                && !succs[lFound].marked);
    }

    /**
     * Returns a random level for inserting a new node.
     * Hardwired to k=1, p=0.5, max 31 (see above and
     * Pugh's "Skip List Cookbook", sec 3.4).
     * <p/>
     * This uses the simplest of the generators described in George
     * Marsaglia's "Xorshift RNGs" paper.  This is not a high-quality
     * generator but is acceptable here.
     */
    private int randomLevel() {
        int x = randomSeed;
        x ^= x << 13;
        x ^= x >>> 17;
        randomSeed = x ^= x << 5;
        if ((x & 0x80000001) != 0) // test highest and lowest bits
            return 0;
        int level = 1;
        while (((x >>>= 1) & 1) != 0) ++level;
        return level;
    }

    private static final class Node<T> {
        final Lock lock = new ReentrantLock();
        final T item;
        final int key;
        final Node<T>[] next;
        volatile boolean marked = false;
        volatile boolean fullyLinked = false;
        private int topLevel;

        public Node(int key) { // sentinel node constructor
            this.item = null;
            this.key = key;
            next = new Node[MAX_LEVEL + 1];
            topLevel = MAX_LEVEL;
        }

        public Node(T x, int height) {
            item = x;
            key = x.hashCode();
            next = new Node[height + 1];
            topLevel = height;
        }

        public void lock() {
            lock.lock();
        }

        public void unlock() {
            lock.unlock();
        }
    }


}
