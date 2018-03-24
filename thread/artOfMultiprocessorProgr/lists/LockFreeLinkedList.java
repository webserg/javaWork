package thread.artOfMultiprocessorProgr.lists;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * User: webserg
 * Date: 31.01.12
 */
public class LockFreeLinkedList<T> implements IList<T> {
    Node head;
    Node tail;

    public LockFreeLinkedList() {
        this.head = new Node(Integer.MIN_VALUE);
        this.tail = new Node(Integer.MAX_VALUE);
        //this.head.next = new AtomicMarkableReference<>(tail, false);
        while (!head.next.compareAndSet(null, tail, false, false)) ;
    }

    public static void main(String[] args) {

        IList<String> ss = new LockFreeLinkedList();

        ss.add("5");
        ss.add("10");
        ss.add("7");
        ss.add("7");
        ss.add("6");
        System.out.println(ss);
    }

    /**
     * public boolean List::insert (KeyType key) {
     * Node *new_node = new Node(key);
     * Node *right_node, *left_node;
     * do {
     * right_node = search (key, &left_node);
     * if ((right_node != tail) && (right_node.key == key))
     * return false;
     * new_node.next=right_node;
     * if(
     * <p/>
     * CAS(&(left_node.next),right_node,new_node
     * <p/>
     * ))
     * return true;
     * }while(true);
     * }
     *
     * @param item
     * @return
     */
    @Override
    public boolean add(T item) {
        int key = item.hashCode();
        Node newNode = new Node(key);
        Node left = null, right;
        do {
            right = search(item, left);
            if ((right != tail) && right.key == key)
                return false;
            newNode.next = new AtomicMarkableReference<>(right, false);
            if (left.next.compareAndSet(right, newNode, false, false))
                return true;
        } while (true);
    }

    /**
     * 1: Find left_node and right_node(iterates along the list find first unmarked)
     * 2: Check nodes are adjacent(if left predecessor of right)   return
     * 3: otherwise use CAS to remove one or more marked nodes  between left and right
     *
     * @param key  key
     * @param left left
     */
    private Node search(T key, Node left) {
        Node pred = null, cur = null, succ = null;
        boolean[] marked = {false}; // is curr marked?
        boolean snip;

        search_again:
        while (true) {
            pred = head;
            cur = pred.next.getReference();
            while (true) {
                succ = cur.next.get(marked);
                while (marked[0]) {           // replace curr if marked
                    snip = pred.next.compareAndSet(cur, succ, false, false);
                    if (!snip) continue search_again;
                    cur = pred.next.getReference(); //if compare and set false try again
                    succ = cur.next.get(marked);
                }
                if (cur.key < key.hashCode()) {
                    pred = cur;
                    cur = succ;
                } else {
                    left = pred;
                    return cur;
                }
            }
        }
    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    public String toString() {
        Node cur = head;
        StringBuilder str = new StringBuilder("[");
        while (cur != null) {
            str.append(cur);
            cur = cur.next.getReference();
        }
        str.append("]");
        return str.toString();
    }

    private class Node {
        int key;
        AtomicMarkableReference<Node> next;

        Node(T k, Node n) {
            key = k.hashCode();
            next = new AtomicMarkableReference<>(n, false);
        }

        Node(int k) {
            key = k;
            next = new AtomicMarkableReference<>(null, false);
        }


    }
}
