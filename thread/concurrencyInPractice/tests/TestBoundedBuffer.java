package thread.concurrencyInPractice.tests;

import junit.framework.TestCase;

import java.util.concurrent.*;

/**
 * TestBoundedBuffer
 * <p/>
 * Basic unit tests for BoundedBuffer
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TestBoundedBuffer extends TestCase {
    private static final long LOCKUP_DETECT_TIMEOUT = 1000;
    private static final int CAPACITY = 1000;
    private static final int THRESHOLD = 1000;

    /**
     * test that the buffer recognizes that it is full (and not empty)
     */
    public void testIsEmptyWhenConstructed() {
        SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());
    }

    public void testIsFullAfterPuts() throws InterruptedException {
        SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        for (int i = 0; i < 10; i++)
            bb.put(i);
        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
    }

    public void testTakeBlocksWhenEmpty() {
        final SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        Thread taker = new Thread() {
            public void run() {
                try {
                    int unused = bb.take();
                    fail(); // if we get here, it's an error

                } catch (InterruptedException success) {
                }
            }
        };
        try {
            // bb.put(1);
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            taker.interrupt();
            // The timed join ensures that the test completes even if
            // take gets stuck in some unexpected way.
            taker.join(LOCKUP_DETECT_TIMEOUT);
            assertFalse(taker.isAlive());
        } catch (Exception unexpected) {
            fail();
        }
    }

    public void testTakeBlocksWhenEmptyUsingFutureBlocks() {
        final SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        Callable<Boolean> taker = () -> {
            try {
                int unused = bb.take();
                return true;

            } catch (InterruptedException success) {
            }
            return false;
        };
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<Boolean> future = executorService.submit(taker);
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            try {
                assertFalse(future.get(1, TimeUnit.SECONDS));
                future.cancel(true);
            } catch (TimeoutException e) {
                assertTrue(true);
            } finally {
                executorService.shutdown();
            }

        } catch (Exception unexpected) {
            fail();
        }

    }

    public void testTakeBlocksWhenEmptyUsingFutureSuccess() {
        final SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        Callable<Integer> taker = () -> {
            try {
                int unused = bb.take();
                return 1;

            } catch (InterruptedException success) {
            }
            return 0;
        };
        try {
            bb.put(1);
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<Integer> future = executorService.submit(taker);
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            try {
                assertEquals(future.get(1, TimeUnit.SECONDS), new Integer(1));
                future.cancel(true);
            } catch (TimeoutException e) {
                assertTrue(true);
            } finally {
                executorService.shutdown();
            }

        } catch (Exception unexpected) {
            fail();
        }
    }

    /*
     * The testLeak method inserts several large objects into a
     * bounded buffer and then removes them; memory usage at heap
     * snapshot #2 should be approximately the same as at heap
     * snapshot #1. On the other hand, if doExtract forgot to null out
     * the reference to the returned element (items[i]=null), the
     * reported memory usage at the two snapshots would definitely not
     * be the same. (This is one of the few times where explicit
     * nulling is necessary; most of the time, it is either not
     * helpful or actually harmful [EJ Item 5].)
     */
    public void testLeak() throws InterruptedException {
        SemaphoreBoundedBuffer<Big> bb = new SemaphoreBoundedBuffer<Big>(CAPACITY);
        long heapSize1 = snapshotHeap();
        for (int i = 0; i < CAPACITY; i++)
            bb.put(new Big());
        for (int i = 0; i < CAPACITY; i++)
            bb.take();
        long heapSize2 = snapshotHeap();
        assertTrue(Math.abs(heapSize1 - heapSize2) < THRESHOLD);
    }

    private long snapshotHeap() {
        Runtime s_runtime = Runtime.getRuntime();
        long Used_memory = s_runtime.totalMemory() - s_runtime.freeMemory();
        return 0;
    }

    class Big {
        double[] data = new double[1000];
    }

}
