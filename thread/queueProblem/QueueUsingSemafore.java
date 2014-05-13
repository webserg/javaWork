package thread.queueProblem;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

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
public class QueueUsingSemafore {
    Semaphore leaderQueue = new Semaphore(0);
    Semaphore followerQueue = new Semaphore(0);
    public static void main(String[] args) {
        QueueUsingSemafore obj = new QueueUsingSemafore();
        Runnable leaders = () -> {
            while(true) {
                obj.followerQueue.release();
                try {
                    obj.leaderQueue.acquire();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("dance leader");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("=============================");
            }
        };

        Runnable followers = () -> {
            while(true) {
                obj.leaderQueue.release();
                try {
                    obj.followerQueue.acquire();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("dance followers");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

        };
        ExecutorService leaderS = Executors.newFixedThreadPool(1);
        ExecutorService followerS = Executors.newFixedThreadPool(1);
        leaderS.submit(leaders);
        followerS.submit(followers);
    }
}
