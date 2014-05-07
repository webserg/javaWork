package thread.concurrencyInPractice.tests;

import java.util.concurrent.CyclicBarrier;

/**
 * PutTakeTest
 * <p/>
 * Producer-consumer test program for BoundedBuffer
 * 
 * @author Brian Goetz and Tim Peierls
 */
public class PutTakeTimerTest extends PutTakeTest {
    protected TimerBarrier timer;

    public PutTakeTimerTest(int capacity, int npairs, int ntrials) {
        super(capacity, npairs, ntrials);
        this.timer = new TimerBarrier();// action will preformed when
        // last thread entering the
        // barrier
        this.barrier = new CyclicBarrier(npairs * 2 + 1, timer);
    }

    public static void main(String[] args) throws Exception {
        int tpt = 100000; // trials per thread
        for (int cap = 1; cap <= 1000; cap *= 10) {
            System.out.println("Capacity: " + cap);
            for (int pairs = 1; pairs <= 128; pairs *= 2) {
                PutTakeTimerTest t = new PutTakeTimerTest(cap, pairs, tpt);
                System.out.print("Pairs: " + pairs + "\t");
                t.test();
                System.out.print("\t");
                Thread.sleep(1000);
                t.test();
                System.out.println();
                Thread.sleep(1000);
            }
        }
        pool.shutdown();
    }

    public void test() {
        try {
            timer.clear();
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await();
            barrier.await();
            long nsPerItem = timer.getTime() / (nPairs * (long) nTrials);
            System.out.print("Throughput: " + nsPerItem + " ns/item");
            assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class TimerBarrier implements Runnable {
        private boolean started;
        private long startTime, endTime;

        
        public void run() {
            long t = System.nanoTime();
            if (started != true) {
                System.out.println("started");
                started = true;
                startTime = t;
            } else {
                System.out.println("finished");
                endTime = t;
            }
        }

        public synchronized void clear() {
            started = false;
        }

        public synchronized long getTime() {
            return endTime - startTime;
        }

    }
}
