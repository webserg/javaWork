package thread.littleBookOfSemafore.rendevouzProblem;

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
    Semaphore mutex = new Semaphore(1);
    Semaphore rendevouz = new Semaphore(1);
    int leaders = 0;
    int followers = 0;

    public static void main(String[] args) {
        QueueUsingSemafore obj = new QueueUsingSemafore();
        Runnable leaders = () -> {
            while (true) {
                try {
                    obj.mutex.acquire();
                    if (obj.followers > 0) {
                        obj.followers--;
                        obj.followerQueue.release();
                    } else {
                        obj.leaders++;
                        obj.mutex.release();
                        obj.leaderQueue.acquire();
                    }
                    obj.rendevouz.acquire();
                    System.out.println("dance leader");
                    obj.mutex.release();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable followers = () -> {
            while (true) {
                try {
                    obj.mutex.acquire();
                    if (obj.leaders > 0) {
                        obj.leaders--;
                        obj.leaderQueue.release();
                    } else {
                        obj.followers++;
                        obj.mutex.release();
                        obj.followerQueue.acquire();

                    }
                    System.out.println("dance followers");
                    System.out.println("---------------------------");
                    obj.rendevouz.release();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

        };
        ExecutorService leaderS = Executors.newFixedThreadPool(4);
        ExecutorService followerS = Executors.newFixedThreadPool(1);
        leaderS.submit(leaders);
        leaderS.submit(leaders);
        leaderS.submit(leaders);
        leaderS.submit(leaders);
        followerS.submit(followers);
//        followerS.submit(followers);
//        followerS.submit(followers);
//        followerS.submit(followers);
    }
}
