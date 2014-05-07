package thread.reentrancy.conditions;

import junit.framework.TestCase;
import org.junit.Test;
import thread.reentrancy.conditions.BoundedBuffer;

/**
 * TestBoundedBuffer
 * <p/>
 * Basic unit tests for BoundedBuffer
 * 
 * @author Brian Goetz and Tim Peierls
 */
public class TestBoundedBuffer extends TestCase {
    private static final long LOCKUP_DETECT_TIMEOUT = 1000;

    @Test
    public void testTakeBlocksWhenEmpty() {
        final   BoundedBuffer bb = new BoundedBuffer();
        Thread taker = new Thread() {
            public void run() {
                try {
                    Object unused = bb.take();
                    fail(); // if we get here, it's an error
                } catch (InterruptedException success) {
                }
            }
        };
        try {
             bb.put(1);
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


}
