package thread.exercises.goteborg.ball.freezingBallsCyclicBarrierOwn;

import java.util.concurrent.Semaphore;

/**
 * Created by webserg on 05.05.2014.
 */
public class MyCyclicBarrier implements MyCyclicBarrierI {
    private int counter;
    private final int p;
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore barrier;

    public MyCyclicBarrier(int parties) {
        p = parties;
        barrier = new Semaphore(p);
        try {
            barrier.acquire(p);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void await() {
        try {
            mutex.acquire();
            counter = counter + 1;
            if(counter == p) {
                counter=0;
                Balls.nap((int) (1000 * Math.random()));
                barrier.release(p);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
        }
        try {
            barrier.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
