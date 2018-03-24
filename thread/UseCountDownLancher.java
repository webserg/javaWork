package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by webserg on 14.05.2014.
 */
public class UseCountDownLancher {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Runnable init = () -> {
            System.out.println("init");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("init going to finish");
            countDownLatch.countDown();
        };
        Runnable finish = () -> {
            try {
                System.out.println("finish started");
                countDownLatch.await();
            } catch (InterruptedException e) {
            }
            System.out.println("finish");
        };
        ExecutorService e = Executors.newSingleThreadExecutor();
        e.execute(finish);
        e.shutdown();
        ExecutorService s = Executors.newFixedThreadPool(5);
        s.submit(init);
        s.submit(init);
        s.submit(init);
        s.submit(init);
        s.submit(init);
        s.shutdown();
    }
}
