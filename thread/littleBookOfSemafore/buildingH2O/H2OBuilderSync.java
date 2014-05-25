package thread.littleBookOfSemafore.buildingH2O;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by webserg on 21.05.2014.
 */
public class H2OBuilderSync {
    Lock mutex = new ReentrantLock();
    int oxygen = 0;
    int hydrogen = 0;
    Condition hydroCon = mutex.newCondition();
    Condition oxyCon = mutex.newCondition();
    boolean done = false;

    public static void main(String[] args) {
        H2OBuilderSync b = new H2OBuilderSync();

        Runnable oxygen = () -> {
            try {
                b.mutex.lock();
                b.oxygen++;
                if (b.hydrogen >= 2) {
                    b.hydrogen -= 2;
                    b.oxygen -= 1;
                    b.done = true;
                    b.hydroCon.signal();
                    b.hydroCon.signal();
                } else {
                    b.oxyCon.await();
                }
                b.mutex.unlock();
                System.out.println("oxy bonded");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable hydrogen = () -> {
            try {
                b.mutex.lock();
                b.hydrogen++;
                if (b.oxygen >= 1 && b.hydrogen >= 2) {
                    b.hydrogen -= 2;
                    b.oxygen -= 1;
                    b.done = true;
                    b.hydroCon.signal();
                    b.oxyCon.signal();
                } else {
                    b.hydroCon.await();
                }
                b.mutex.unlock();
                System.out.println("hyd bonded");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        ExecutorService s = Executors.newCachedThreadPool();
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 5; i++) {

            timer.schedule(oxygen, 1 * i, TimeUnit.SECONDS);
        }
        for (int i = 0; i < 10; i++)
            s.submit(hydrogen);
        s.shutdown();
        timer.shutdown();
    }
}
