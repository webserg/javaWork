package thread.producerConsumer;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Semaphores can also be used to represent a queue. In this case, the initial value
 * is 0, and usually the code is written so that it is not possible to signal unless
 * there is a thread waiting, so the value of the semaphore is never positive.
 * For example, imagine that threads represent ballroom dancers and that two
 * kinds of dancers, leaders and followers, wait in two queues before entering the
 * dance floor. When a leader arrives, it checks to see if there is a follower waiting.
 * If so, they can both proceed. Otherwise it waits.
 * Similarly, when a follower arrives, it checks for a leader and either proceeds
 * or waits, accordingly.
 * Puzzle: write code for leaders and followers that enforces these constraints.
 * Created by webserg on 13.05.2014.
 */
public class RendevouzUsingExchanger {
    Exchanger<Integer> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        RendevouzUsingExchanger obj = new RendevouzUsingExchanger();
        Runnable leaders = () -> {
            int k = 0;
            while (true) {
                try {
                    k = obj.exchanger.exchange(++k);
                    System.out.println("dance leader = " + k);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("=============================");
            }
        };

        Runnable followers = () -> {
            int k = 0;
            while (true) {
                try {
                    k = obj.exchanger.exchange(++k);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println("dance followers = " + k);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

        };
        ExecutorService leaderS = Executors.newSingleThreadExecutor();
        ExecutorService followerS = Executors.newSingleThreadExecutor();
        leaderS.submit(leaders);
        followerS.submit(followers);
        leaderS.shutdown();
        followerS.shutdown();
    }
}
