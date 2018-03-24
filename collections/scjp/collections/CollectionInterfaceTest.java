package collections.scjp.collections;

import java.util.LinkedList;
import java.util.Queue;

public class CollectionInterfaceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<String>();

        q.add("Veronica");
        q.add("Walance");
        q.add("Duncan");
        showAll(q);
    }

    public static void showAll(Queue q) {
        q.add(new Integer(42));
        while (!q.isEmpty())
            System.out.println(q.remove() + " ");
    }
}
