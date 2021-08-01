package thread.concurrencyInPractice.cache;

import java.util.concurrent.*;

/**
 * Nearly every server application uses some form of
 * caching. Reusing the results of a previous computation
 * can reduce latency and increase throughput, at the cost
 * of some additional memory usage.
 *
 * @author Sergiy Doroshenko webserg@gmail.com Feb 10, 2009
 * 4:41:41 PM
 */
public class Memoizer4<A, V> {
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer4(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * Memoizer3 is vulnerable because a compound action
     * (put-if-absent) is performed on the backing map that
     * cannot be made atomic using locking. Memoizer4 takes
     * advantage of the atomic putIfAbsent method of
     * ConcurrentMap, closing the window of vulnerability in
     * Memoizer3
     *
     * @param arg
     * @return
     * @throws InterruptedException
     */
    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                public V call() throws InterruptedException {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            /**
             * put if absent - method puts value only if key
             * doesn't exists in map, equivalent
             * if(!map.containsKey(key)) 
             *  return map.put(key,value);
             */
            f = cache.putIfAbsent(arg, ft);
            if (f == null) {
                f = ft;
                ft.run();
            }
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }

}
