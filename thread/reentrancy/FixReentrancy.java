package thread.reentrancy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ReentrantLock provides the same locking and memory semantics as intrinsic locking, as well as
 * additional features such as timed lock waits, interruptible lock waits, fairness, and the ability to
 * implement non-block-structured locking. The performance of ReentrantLock appears to
 * dominate that of intrinsic locking, winning slightly on Java 6 and dramatically on Java 5.0. So
 * why not deprecate synchronized and encourage all new concurrent code to use ReentrantLock?
 * Some authors have in fact suggested this, treating synchronized as a "legacy" construct. But this
 * is taking a good thing way too far.
 * Intrinsic locks still have significant advantages over explicit locks. The notation is familiar and
 * compact, and many existing programs already use intrinsic lockingand mixing the two could be
 * confusing and error-prone. Reentrant-Lock is definitely a more dangerous tool than
 * synchronization; if you forget to wrap the unlock call in a finally block, your code will
 * probably appear to run properly, but you've created a time bomb that may well hurt innocent
 * bystanders. Save ReentrantLock for situations in which you need something ReentrantLock
 * provides that intrinsic locking doesn't.
 * ReentrantLock is an advanced tool for situations where intrinsic locking is not
 * practical. Use it if you need its advanced features: timed, polled, or interruptible lock
 * acquisition, fair queueing, or non-block-structured locking. Otherwise, prefer
 * synchronized..
 */
public class FixReentrancy {
    Object first = new Object();
    Object second = new Object();

    public static void main(String[] args) {
        final FixReentrancy object = new FixReentrancy();

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
        //
        //result will be:
        //second enter
        //first enter
        //first exit
        //second exit
        //for synchronization we use different object not object this
        //so threads can execute both methods simultaniously
        //it is main differance from usual synchronize
        //
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(t2);
        ex.execute(t1);
        ex.shutdown();

    }

    public void first() {
        synchronized (first) {
            System.out.println("first enter");
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                i++;
            }
            System.out.println("first exit");
        }
    }

    public void second() {
        synchronized (second) {
            System.out.println("second enter");
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                i++;
            }
            System.out.println("second exit");
        }
    }

}
