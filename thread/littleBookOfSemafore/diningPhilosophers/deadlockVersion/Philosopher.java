package thread.littleBookOfSemafore.diningPhilosophers.deadlockVersion;

import java.util.concurrent.Semaphore;

/**
 * Created by webserg on 05.05.2014.
 *
 * if process pick up left fork then right is't lead to deadlock
 *
 */
public class Philosopher implements Runnable {

    public static final Semaphore[] forks = new Semaphore[]{new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};

    final int positionAtTable;

    public Philosopher(int i) {
        positionAtTable = i;
    }

    @Override
    public void run() {
        while (true) {
            int[] forkIdx = getForkIdx();
            int leftFork = forkIdx[0];
            int rightFork = forkIdx[1];
            try {
                forks[leftFork].acquire();

                forks[rightFork].acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            eat();
            forks[leftFork].release();
            forks[rightFork].release();
            think();
        }
    }

    private int[] getForkIdx() {
        int leftFork = positionAtTable;
        int rightFork;
        if (positionAtTable == 4) rightFork=0;
        else rightFork = positionAtTable + 1;
        return new int[]{leftFork,rightFork};
    }

    public void eat() {
        System.out.println("eat = " + positionAtTable);
        nap((int) (100 * Math.random()));
    }

    public void think() {
        System.out.println("think = " + positionAtTable);
        nap((int) (100 * Math.random()));
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
}
