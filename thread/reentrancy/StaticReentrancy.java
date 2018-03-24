package thread.reentrancy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * reentrancy is a thread that is holding the lock can acquire it again without blocking.
 * * Recall that a thread cannot acquire a lock owned by another thread. But a thread can
 * acquire a lock that it already owns.
 * Allowing a thread to acquire the same lock more than once enables reentrant synchronization.
 */
public class StaticReentrancy {
    public static synchronized void first() {
        System.out.println("first enter");
        int i = 0;
        while (i < Integer.MAX_VALUE) {
            i++;
        }
        System.out.println("first exit");
    }

    public static synchronized void second() {
        System.out.println("second enter");
        int i = 0;
        while (i < Integer.MAX_VALUE) {
            i++;
        }
        System.out.println("second exit");
    }

    public static void main(String[] args) {
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                StaticReentrancy.first();
            }
        };
        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                StaticReentrancy.second();
            }
        };

        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(t2);
        ex.execute(t1);
        ex.shutdown();

    }

}
