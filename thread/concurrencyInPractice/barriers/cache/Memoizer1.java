package thread.concurrencyInPractice.barriers.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Nearly every server application uses some form of
 * caching. Reusing the results of a previous computation
 * can reduce latency and increase throughput, at the cost
 * of some additional memory usage.
 *
 * @author Sergiy Doroshenko webserg@gmail.com Feb 10, 2009
 * 4:41:41 PM
 */
public class Memoizer1<A, V> {
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * HashMap is not thread-safe, so to ensure that two
     * threads do not access the HashMap at the same time,
     * Memoizer1 takes the conservative approach of
     * synchronizing the entire compute method. This ensures
     * thread safety but has an obvious scalability problem:
     * only one thread at a time can execute compute at all.
     * (for example: if two different threads get two different
     * value, second thread will be wait for first thread for
     * compute value)
     *
     * @param arg
     * @return
     * @throws InterruptedException
     */
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }

}
