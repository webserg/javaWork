package thread.concurrencyInPractice.barriers.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Nearly every server application uses some form of
 * caching. Reusing the results of a previous computation
 * can reduce latency and increase throughput, at the cost
 * of some additional memory usage.
 *
 * @author Sergiy Doroshenko webserg@gmail.com Feb 10, 2009
 * 4:41:41 PM
 */
public class Memoizer2<A, V> {
    private final ConcurrentMap<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * Memoizer2 using ConcurrentHashMap certainly has
     * better concurrent behavior than Memoizer1: multiple
     * threads can actually use it concurrently. But it
     * still has some defects as a cachethere is a window of
     * vulnerability in which two threads calling compute at
     * the same time could end up computing the same value.
     * <p>
     * The problem with Memoizer2 is that if one thread
     * starts an expensive computation, other threads are
     * not aware that the computation is in progress and so
     * may start the same computation
     *
     * @param arg
     * @return
     * @throws InterruptedException
     */
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }

}
