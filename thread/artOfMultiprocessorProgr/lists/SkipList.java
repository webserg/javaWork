package thread.artOfMultiprocessorProgr.lists;

import webserg.scjp.arrays.Arrays;

/**
 * Traditionally balanced trees have been used to efficiently implement Set and HashMap style data structures.
 * Balanced tree algorithms are characterized by the need to continually rebalance the tree as operations are performed.
 * This is necessary in order to assure good performance.
 * <p/>
 * Skip Lists are a data structure that was developed by William Pugh as a probabilistic alternative to balanced trees.
 * The balancing of a Skip List is achieved through the use of a random number generator.
 * <p/>
 * The benefit of the Skip List is that the algorithms for search, insertion and deletion are rather simple.
 * This provides improved constant time overhead as compared to balanced trees.
 * The algorithms involved are also relatively easy to understand.
 * <p/>
 * In a singly linked list each node contains one pointer to the next node in the list. A node in a Skip List contains an array of pointers.
 * The size of this array is chosen at random (between 0 and some MAX_LEVEL) at the time when the node is created.
 * The size of this array determines the level of the node. For example, a level 3 node has 4 forward pointers, indexed from 0 to 3.
 * The pointer at index 0 (called the level 0 forward pointer) always points to the immediate next node in the list.
 * The other pointers however point to nodes further down the list, and as such if followed allow portions of the list to be skipped over. A level i pointer
 * points to the next node in the list that has level >= i.
 * <p/>
 * The implementation of skip lists given by William Pugh states that the list should be terminated by a special NIL node that stores a value greater
 * than any legal value.
 * This stipulation was made so that the algorithms described in his paper would be very simple as they never had to explicitly check for pointers
 * pointing at NIL. I will instead set the initial value of all pointer fields to null.
 * <p/>
 * A level 0 node will have one forward pointer, a level 1 node will have two forward pointers and so on. Therefore we need to add one to the
 * level when allocating memory for the array of forward pointers.
 * <p/>
 * <p/>
 * User: webserg
 * Date: 10.01.12
 */
public class SkipList<T extends Comparable> implements IList<T> {


    public static final double P = 0.5;
    static final int MAX_LEVEL = 5;
    final Node<T> head = new Node<>(MAX_LEVEL, null);
    private int level = 0;//hightes level exists in skip list

    private static final class Node<T extends Comparable> {
        final T item;
        final Node<T>[] next;
        //  private int level;

        public Node(int level, T t) { // sentinel node constructor
            this.item = t;
            //@SuppressWarnings("Unchecked")
            next = new Node[level + 1];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }

    /*8
   If a node is found with the same value as the value that is to be inserted then
    nothing should be done (a mathematical set cannot contain duplicates).
    Otherwise we must create a new node and insert it into the list.
    */
    @Override
    public boolean add(T item) {
        Node<T> curr = head;
        Node<T>[] update = new Node[MAX_LEVEL + 1];
        //find and record updates
        for (int lev = level; lev >= 0; lev--) {
            while (
                    curr.next[lev] != null
                            &&
                            curr.next[lev].item.compareTo(item) < 0
                    ) {
                curr = curr.next[lev];
            }
            update[lev] = curr;
        }
        //record header updates
        curr = curr.next[0];

        if (curr == null || !curr.item.equals(item)) {
            int lvl = randomLevel();
            //If the new node is greater than any node already in the list then the header
            // node must be updated and the level of the list must be set to the new level.
            if (lvl > level) {

                for (int i = level + 1; i <= lvl; i++) {
                    update[i] = head;
                }

                level = lvl;   //set hightest level
            }

            //Two things must be done to insert the node. We must make the new
            // node x point at what the nodes in the update vector are currently
            // pointing at. Then we update the nodes in the |update| vector to point at x.
            curr = new Node<>(lvl, item);

            for (int i = 0; i <= lvl; i++) {

                curr.next[i] = update[i].next[i];   //set link on hightest level then 0 ; set next  to successor
                update[i].next[i] = curr; //predsessor next set to curr

            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T item) {
        Node<T> curr = head;
        Node<T>[] update = new Node[MAX_LEVEL + 1];
        //find and record updates
        for (int lev = level; lev >= 0; lev--) {
            while (
                    curr.next[lev] != null
                            &&
                            curr.next[lev].item.compareTo(item) < 0
                    ) {
                curr = curr.next[lev];
            }
            update[lev] = curr;
        }

        if(curr.item.compareTo(item) == 0){
            System.out.println(java.util.Arrays.toString(update));
        }

        return false;
    }

    @Override
    public boolean contains(T item) {
        Node<T> curr = head;
        for (int lvl = level; lvl >= 0; lvl--) {
            while (curr.next[lvl] != null && curr.next[lvl].item.compareTo(item) < 0) {
                curr = curr.next[lvl];
            }

        }
        if (curr.item.compareTo(item) == 0) return true;
        return false;
    }

    public static int randomLevel() {
        int lvl = (int) (Math.log(1. - Math.random()) / Math.log(1. - P));
        return Math.min(lvl, MAX_LEVEL);
    }

    public String toString() {
        Node cur = head;
        StringBuilder str = new StringBuilder("[");
        while (cur != null) {
            str.append(cur);
            cur = cur.next[0];
        }
        str.append("]");
        return str.toString();
    }


    public static void main(String[] args) {

        SkipList<Integer> ss = new SkipList<>();

        ss.add(5);
        ss.add(10);
        ss.add(7);
        ss.add(7);
        ss.add(6);
        System.out.println(ss);
        //assert ss.toString().equals("{5,6,7,10}");
        assert ss.contains(7);
        assert !ss.contains(17);
        ss.remove(7)  ;
        assert ss.contains(7);

    }
}
