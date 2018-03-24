package thread.liveness;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class ThreadBlocking {

    private static final int LIST_SIZE = 100000;

    private List<String> a = Collections.synchronizedList(
            new LinkedList<>(Collections.nCopies(LIST_SIZE * 3, "aac"))
    );

    private List<String> b = Collections.synchronizedList(
            new LinkedList<>(Collections.nCopies(LIST_SIZE * 10, "bb"))
    );


    public static void main(String[] args) {
        final ThreadBlocking tb = new ThreadBlocking();
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("T1 starts");
                long time = System.currentTimeMillis();
                tb.a.contains(tb.b);
                System.out.println("T1 finished in " + (System.currentTimeMillis() - time) + " millis");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                System.out.println("T2 starts");
                long time = System.currentTimeMillis();
                tb.b.addAll(tb.a);
                System.out.println("T2 finished in " + (System.currentTimeMillis() - time) + " millis");
            }
        };
        t1.start();
        t2.start();

    }


}
