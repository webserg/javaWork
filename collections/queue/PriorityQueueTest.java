package collections.queue;

import org.junit.Assert;
import org.junit.Test;
import thread.caches.KeyObject;
import thread.caches.lfu.CountKey;

import java.util.*;

/**
 * need queue with support ordering and for example if
 * object in queue was changed from outside
 * queue must change ordering accroding to changes
 *
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/19/11 12:31 PM
 */
public class PriorityQueueTest {
    /**
     * a priority queue is used to sort a collection of elements. Again this program is artificial in that
     * there is no reason to use it in favor of the sort method provided in Collections,
     * but it illustrates the behavior of priority queues
     *
     * @param c
     * @param <E>
     * @return
     */
    static <E> List<E> heapSort(Collection<E> c) {
        Queue<E> queue = new PriorityQueue<>(c);
        List<E> result = new ArrayList<>();
        while (!queue.isEmpty())
            result.add(queue.remove());
        System.out.println(result);
        return result;
    }

    @Test
    public void testOrder() {
        Queue<CountKey<KeyObject>> queue = new PriorityQueue<CountKey<KeyObject>>(10);
        List<CountKey<KeyObject>> keys = new ArrayList<CountKey<KeyObject>>();
        for (int i = 0; i < 10; i++) {
            CountKey<KeyObject> k = new CountKey<KeyObject>(new KeyObject(i + ""));
            if (i == 7) {
                k.incrementCount();
                k.incrementCount();
                k.incrementCount();
            }
            keys.add(k);
            queue.offer(k);
        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(queue.peek());
//        }

        keys.get(5).incrementCount();
        keys.get(6).incrementCount();
        keys.get(5).incrementCount();
        queue = new PriorityQueue<>(keys);
        queue.poll();
        queue.offer(new CountKey<>(new KeyObject(87 + "")));
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.poll());
        }
    }

    @Test
    public void testHeapSortUsingPriorityQueue() {
        List<String> l = Arrays.asList(new String[]{"cc", "bb", "aa"});
        Assert.assertArrayEquals(new String[]{"aa", "bb", "cc"}, heapSort(l).toArray());
    }
}
