/*
 * LockFreeList.java
 *
 * Created on January 4, 2006, 2:41 PM
 *
 * From "Multiprocessor Synchronization and Concurrent Data Structures",
 * by Maurice Herlihy and Nir Shavit.
 * Copyright 2006 Elsevier Inc. All rights reserved.
 */

package thread.artOfMultiprocessorProgr.lists;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * Lock-free List based on M. Michael's algorithm.
 * <p/>
 * Nonblocking synchronization: Sometimes we can eliminate locks entirely,
 * relying on built-in atomic operations such as compareAndSet() for synchronization.
 *
 * @author Maurice Herlihy
 */
public class LockFreeList<T> implements IList<T> {
    /**
     * First list node
     */
    Node head;

    /**
     * Constructor
     */
    public LockFreeList() {
        this.head = new Node(Integer.MIN_VALUE);
        Node tail = new Node(Integer.MAX_VALUE);
        while (!head.next.compareAndSet(null, tail, false, false)) ;
    }

    /**
     * Add an element.
     *
     * @param item element to add
     * @return true iff element was not there already
     */
    public boolean add(T item) {
        int key = item.hashCode();
        boolean splice;
        while (true) {
            // find predecessor and curren entries
            Window window = find(head, key);
            Node pred = window.pred, curr = window.curr;
            // is the key present?
            if (curr.key == key) {
                return false;
            } else {
                // splice in new node
                Node node = new Node(item);
                node.next = new AtomicMarkableReference(curr, false);
                if (pred.next.compareAndSet(curr, node, false, false)) {
                    return true;
                }
            }
        }
    }

    /**
     * Remove an element.
     *
     * @param item element to remove
     * @return true iff element was present
     */
    public boolean remove(T item) {
        int key = item.hashCode();
        boolean snip;
        while (true) {
            // find predecessor and curren entries
            Window window = find(head, key);
            Node pred = window.pred, curr = window.curr;
            // is the key present?
            if (curr.key != key) {
                return false;
            } else {
                // snip out matching node
                Node succ = curr.next.getReference();
                snip = curr.next.attemptMark(succ, true);
                if (!snip)
                    continue;
                pred.next.compareAndSet(curr, succ, false, false);
                return true;
            }
        }
    }

    /**
     * Test whether element is present
     *
     * @param item element to test
     * @return true iff element is present
     */
    public boolean contains(T item) {
        int key = item.hashCode();
        // find predecessor and curren entries
        Window window = find(head, key);
        Node pred = window.pred, curr = window.curr;
        return (curr.key == key);
    }

    /**
     * list node
     */
    private class Node {
        /**
         * actual item
         */
        T item;
        /**
         * item's hash code
         */
        int key;
        /**
         * next node in list
         */
        AtomicMarkableReference<Node> next;

        /**
         * Constructor for usual node
         *
         * @param item element in list
         */
        Node(T item) {      // usual constructor
            this.item = item;
            this.key = item.hashCode();
            this.next = new AtomicMarkableReference<Node>(null, false);
        }

        /**
         * Constructor for sentinel node
         *
         * @param key should be min or max int value
         */
        Node(int key) { // sentinel constructor
            this.item = null;
            this.key = key;
            this.next = new AtomicMarkableReference<Node>(null, false);
        }
    }

    class Window {
        public Node pred;
        public Node curr;
        Window(Node pred, Node curr) {
            this.pred = pred;
            this.curr = curr;
        }
    }

    /**
     * If element is present, returns node and predecessor. If absent, returns
     * node with least larger key.
     *
     * @param head start of list
     * @param key  key to search for
     * @return If element is present, returns node and predecessor. If absent, returns
     *         node with least larger key.
     */
    public Window find(Node head, int key) {
        Node pred = null, curr = null, succ = null;
        boolean[] marked = {false}; // is curr marked?
        boolean snip;
        retry:
        while (true) {
            pred = head;
            curr = pred.next.getReference();
            while (true) {
                succ = curr.next.get(marked);
                while (marked[0]) {           // replace curr if marked
                    snip = pred.next.compareAndSet(curr, succ, false, false);
                    if (!snip) continue retry;
                    curr = pred.next.getReference();
                    succ = curr.next.get(marked);
                }
                if (curr.key >= key)
                    return new Window(pred, curr);
                pred = curr;
                curr = succ;
            }
        }
    }

    public String toString() {
        Node cur = head;
        StringBuilder str = new StringBuilder("[");
        while (cur != null) {
            str.append(cur.item);
            cur = cur.next.getReference();
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {

        IList<Integer> ss = new LockFreeList<>();

        ss.add(5);
        ss.add(10);
        ss.add(7);
        ss.add(7);
        ss.add(6);
        System.out.println(ss);
        ss.remove(7);
        System.out.println(ss);
    }
}
