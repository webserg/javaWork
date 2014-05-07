package thread.artOfMultiprocessorProgr.lists;

import junit.framework.TestCase;
import thread.concurrencyInPractice.tests.SemaphoreBoundedBuffer;

/**
 * User: webserg
 * Date: 01.01.12
 */
public class TestList extends TestCase {

    public void testIsEmptyWhenConstructed() {
        IList<String> list = new CoarseList<>();
        assertFalse(list.contains("a"));
    }

    public void testShouldFindAWhenAddA() {
        IList<String> list = new CoarseList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        assertTrue(list.contains("a"));
        System.out.println(list);

    }

    public void testTakeBlocksWhenEmpty() {
        final IList<String> list = new CoarseList<>();
        Thread t1 = new Thread("1") {
            public void run() {
                System.out.println(list.add("a") + this.getName());
            }
        };
        Thread t2 = new Thread("2") {
            public void run() {
                System.out.println(list.add("a") + this.getName());
            }
        };
        try {

            t2.start();
            t1.start();
            t2.join();
        } catch (Exception unexpected) {
            System.out.println(unexpected.toString());
        }
        assertEquals("{a:}", list.toString());
    }


}
