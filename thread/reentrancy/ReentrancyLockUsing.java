package thread.reentrancy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrancy is a thread that is holding the lock can acquire it again without blocking.
 * Recall that a thread cannot acquire a lock owned by another thread. But a thread can
 * acquire a lock that it already owns.
 * Allowing a thread to acquire the same lock more than once enables reentrant synchronization.
 *
 * The ReentrantLock class, which implements Lock, has the same concurrency and
 * memory semantics as synchronized, but also adds features like lock polling,
 * timed lock waits, and interruptible lock waits. Additionally, it offers far better
 * performance under heavy contention. (In other words, when many threads are
 * attempting to access a shared resource, the JVM will spend less time scheduling
 * threads and more time executing them.)
 *
 * http://www.ibm.com/developerworks/java/library/j-jtp10264/
 */
public class ReentrancyLockUsing {
    final Lock RLock = new ReentrantLock();

    public void first(String name) {
        Lock lock = RLock;
        lock.lock();
        try {
            System.out.println("first enter = " + name);
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                i++;
            }
            System.out.println("first exit = "  + name);
        } finally {
            lock.unlock();
        }
    }

    public void second(String name) {
        Lock lock = RLock;
        lock.lock();
        try {
            System.out.println("second enter = " + name);
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                i++;
            }
            System.out.println("second exit = " + name);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReentrancyLockUsing object = new ReentrancyLockUsing();

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                object.first("A");
                object.second("A");
            }
        };
        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                object.second("B");
                object.first("B");
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
        ex.execute(t2);
        ex.execute(t1);
        ex.shutdown();

    }

}
