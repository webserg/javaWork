package collections.queue;

import java.util.PriorityQueue;

public class PQ {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("carrot");
        pq.add("apple");
        pq.add("banana");
        for (String s : pq) {
            System.out.println(s);
        }
        while (!pq.isEmpty())
            System.out.println(pq.poll());

        PriorityQueue<Integer> pqInt = new PriorityQueue<Integer>();
        pqInt.add(6);
        pqInt.add(1);
        pqInt.add(3);
        pqInt.add(0);
        for (int s : pqInt) {
            System.out.println(s);
        }
        while (!pqInt.isEmpty())
            System.out.println(pqInt.poll());

    }

}
