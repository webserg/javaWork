package thread.semaphores.basicSynchPatterns.signaling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * User: webserg
 * Date: 20.12.11
 * <p/>
 * Puzzle: Generalize the signal pattern so that it works both ways. Thread A has
 * to wait for Thread B and vice versa. In other words, given this code
 * Thread A
 * 1 statement a1
 * 2 statement a2
 * Thread B
 * 1 statement b1
 * 2 statement b2
 * we want to guarantee that a1 happens before b2 and b1 happens before a2. In
 * writing your solution, be sure to specify the names and initial values of your
 * semaphores
 */
public class RendezvousPattern {
    public static void main(String[] args) {
        final Semaphore aArrived = new Semaphore(0);
        final Semaphore bArrived = new Semaphore(0);
        Runnable a = new Runnable() {
            @Override
            public void run() {
                System.out.println("a1");
                try {
                    aArrived.release();
                    bArrived.acquire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("a2");
            }
        };
        Runnable b = new Runnable() {
            @Override
            public void run() {
                System.out.println("b1");
                try {
                    bArrived.release();
                    aArrived.acquire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("b2");
            }

        };

        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(a);
        ex.execute(b);
        ex.shutdown();
    }
}
