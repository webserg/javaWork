package collections.maps;

/**
 * User: Sergiy Doroshenko
 * Date: 1/12/11 11:56 AM
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The simple approach to synchronization taken by both Hashtable and synchronizedMap -- synchronizing
 * each method on the Hashtable or the synchronized Map wrapper object -- has two principal deficiencies.
 * It is an impediment to scalability, because only one thread can access the hash table at a time.
 * At the same time, it is insufficient to provide true thread safety, in that many common compound
 * operations still require additional synchronization. While simple operations such as get() and put()
 * can complete safely without additional synchronization, there are several common sequences of operations,
 * such as iteration or put-if-absent, which still require external synchronization to avoid data races.
 */
public class ConcurrentHashMapUsing {
    public static void main(String[] args) {
        /*
        The synchronized collections wrappers, synchronizedMap and synchronizedList,
        are sometimes called conditionally thread-safe -- all individual operations are
        thread-safe, but sequences of operations where the control flow depends on the results of previous
        operations may be subject to data races.
         */

        Map map = Collections.synchronizedMap(new HashMap());
        List list = Collections.synchronizedList(new ArrayList());

        // put-if-absent idiom -- contains a race condition
        // may require external synchronization
        Object key = new Object();
        String value = "";
        if (!map.containsKey(key))
            map.put(key, value);

        // ad-hoc iteration -- contains race conditions
        // may require external synchronization
        for (int i = 0; i < list.size(); i++) {
            doSomething(list.get(i));
        }

        // normal iteration -- can throw ConcurrentModificationException
        // may require external synchronization
        for (Iterator i = list.iterator(); i.hasNext(); ) {
            doSomething(i.next());
        }

        //One of the most common applications for Map in server applications is to implement a cache.
        //A typical characteristic of cache workload is that retrievals are much more common than
        // updates, so (ideally) a cache would offer very good get() performance.
        // A cache that impedes application performance is worse than no cache at all.

        //If you use synchronizedMap to implement a cache, you are introducing a potential
        // scalability bottleneck into your application. Only one thread can access the Map at once,
        // and this includes all the threads that might be retrieving a value out of the Map as well as threads
        // that want to install a new (key, value) pair into the map.

        //The ConcurrentHashMap class from util.concurrent is a thread-safe implementation of Map that offers far better concurrency than
        // synchronizedMap. Multiple reads can almost always execute concurrently,
        // simultaneous reads and writes can usually execute concurrently, and multiple simultaneous
        // writes can often execute concurrently.

        //Iterators returned by ConcurrentHashMap.iterator() will return each element once at most and
        // will not ever throw ConcurrentModificationException, but may or may not reflect insertions
        // or removals that occurred since the iterator was constructed
    }

    public static void doSomething(Object o) {
        var map = new ConcurrentHashMap<>();
        map.put("key", " value");
        System.out.println(map.get("key"));
        map.keySet().spliterator();
    }

}
