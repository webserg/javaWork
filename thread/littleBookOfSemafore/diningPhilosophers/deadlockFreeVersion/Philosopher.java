package thread.littleBookOfSemafore.diningPhilosophers.deadlockFreeVersion;

import java.util.concurrent.Semaphore;

/**
 * Created by webserg on 05.05.2014.
 * * if process pick up left fork then right is't lead to deadlock
 * to avoid this avoid circular waiting
 * for example odd-number philosopher pick up fork in one order
 * even-number  philosopher pick up in another order
 */
public class Philosopher implements Runnable {

    public static final Semaphore[] forks = new Semaphore[]{new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};

    final int positionAtTable;

    public Philosopher(int i) {
        positionAtTable = i;
    }

    public static void nap(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            //
            //  Print out the positionAtTable of the tread that caused this.
            //
            System.err.println("Thread " + Thread.currentThread().getName() +
                    " throwed exception " + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            int[] forkIdx = getForkIdx();
            int leftFork;
            int rightFork;
            leftFork = forkIdx[0];
            rightFork = forkIdx[1];

            try {
                if (positionAtTable % 2 == 0) {
                    forks[leftFork].acquire();
                    forks[rightFork].acquire();
                } else {
                    forks[rightFork].acquire();
                    forks[leftFork].acquire();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            eat();
            if (positionAtTable % 2 == 0) {
                forks[leftFork].release();
                forks[rightFork].release();
            } else {
                forks[rightFork].release();
                forks[leftFork].release();
            }

            think();
        }
    }

    private int[] getForkIdx() {
        int leftFork = positionAtTable;
        int rightFork;
        if (positionAtTable == 4) rightFork = 0;
        else rightFork = positionAtTable + 1;
        return new int[]{leftFork, rightFork};
    }

    public void eat() {
        System.out.println("eat = " + positionAtTable);
        nap((int) (100 * Math.random()));
    }

    public void think() {
        System.out.println("think = " + positionAtTable);
        nap((int) (100 * Math.random()));
    }
}
