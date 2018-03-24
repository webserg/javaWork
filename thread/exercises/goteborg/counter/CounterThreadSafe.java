package thread.exercises.goteborg.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by webserg on 03.05.2014.
 */
public class CounterThreadSafe implements Runnable {
    private final int rounds = 100000;
    private AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        try {
            CounterThreadSafe c = new CounterThreadSafe();

            // Create two threads that run our run () method.
            Thread t1 = new Thread(c, "thread1");
            Thread t2 = new Thread(c, "thread2");

            t1.start();
            t2.start();

            // Wait for the threads to finish.
            t1.join();
            t2.join();

            // Print the counter
            System.out.println(c.counter.get());
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }
    }

    public void run() {
//    try {
        for (int i = 0; i < rounds; i++) {
            counter.incrementAndGet();
        }
//    } catch (InterruptedException e) {
//      System.out.println ("Interrupted!");
//    }
    }
}
