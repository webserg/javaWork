package thread.littleBookOfSemafore.diningPhilosophers.deadlockFreeVersion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by webserg on 05.05.2014.
 */
public class DiningTable {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[]{new Philosopher(0), new Philosopher(1), new Philosopher(2), new Philosopher(3), new Philosopher(4)};
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (Philosopher p : philosophers) {
//            executor.execute(p);
            new Thread(p).start();
        }
        executor.shutdown();
    }
}
