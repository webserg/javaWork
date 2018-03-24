package thread.reentrancy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * reentrancy is a thread that is holding the lock can acquire it again without blocking.
 * Recall that a thread cannot acquire a lock owned by another thread. But a thread can
 * acquire a lock that it already owns.
 * Allowing a thread to acquire the same lock more than once enables reentrant synchronization.
 * <p>
 * This parallels the semantics of synchronized; if a thread enters a synchronized block
 * protected by a monitor that the thread already owns, the thread will be allowed to proceed,
 * and the lock will not be released when the thread exits the second (or subsequent) synchronized
 * block, but only will be released when it exits the first synchronized block it entered protected by that monitor.
 */
public class ReentrancyIssue {
    public static void main(String[] args) {
        final ReentrancyIssue object = new ReentrancyIssue();

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                object.first();
            }
        };
        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                object.second();
            }
        };
        /*
        result will be:
        first enter
        first exit
        second enter
        second exit

        if one thread already owns lock for object(this)
        another thread can't acquire this lock
        so if one thread already in synchronized
        another thread can't enter into another synchr method on the same class
         */
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(t1);
        ex.execute(t2);
        ex.shutdown();

    }

    public synchronized void first() {
        System.out.println("first enter");
        int i = 0;
        while (i < Integer.MAX_VALUE) {
            i++;
        }
        System.out.println("first exit");
    }

    public synchronized void second() {
        System.out.println("second enter");
        int i = 0;
        while (i < Integer.MAX_VALUE) {
            i++;
        }
        System.out.println("second exit");
    }

}
