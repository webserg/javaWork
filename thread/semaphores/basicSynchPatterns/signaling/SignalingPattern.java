package thread.semaphores.basicSynchPatterns.signaling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * User: webserg
 * Date: 18.12.11
 * <p/>
 * Signaling makes it possible to guarantee that a section of code in one thread
 * will run before a section of code in another thread; in other words, it solves the
 * serialization problem.
 * Assume that we have a semaphore named sem with initial value 0, and that
 * Threads A and B have shared access to it.
 * Thread A
 * 1 statement a1
 * 2 sem.signal()
 * Thread B
 * 1 sem.wait()
 * 2 statement b1
 * The word statement represents an arbitrary program statement. To make
 * the example concrete, imagine that a1 reads a line from a file, and b1 displays
 * the line on the screen. The semaphore in this program guarantees that Thread
 * A has completed a1 before Thread B begins b1.
 * Here’s how it works: if thread B gets to the wait statement first, it will find
 * the initial value, zero, and it will block. Then when Thread A signals, Thread
 * B proceeds.
 * Similarly, if Thread A gets to the signal first then the value of the semaphore
 * will be incremented, and when Thread B gets to the wait, it will proceed immediately.
 * Either way, the order of a1 and b1 is guaranteed.
 */
public class SignalingPattern {
    public static void main(String[] args) {
        final Semaphore sem = new Semaphore(0);
        Runnable a = new Runnable() {
            @Override
            public void run() {
                System.out.println("a1");
                try {
                    sem.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable b = new Runnable() {
            @Override
            public void run() {
                try {
                    sem.acquire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("b1");
            }

        };

        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(b);
        ex.execute(a);
        ex.shutdown();
    }
}
