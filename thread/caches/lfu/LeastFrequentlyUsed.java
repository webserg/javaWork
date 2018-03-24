package thread.caches.lfu;

import thread.caches.Cache;

import java.util.*;

/**
 * not thread safe version of cache with simple queue collection like cache
 * <p/>
 * I am Least Frequently used; I count how often an entry is needed by incrementing a counter
 * associated with each entry.
 * <p/>
 * I remove the entry with least frequently used counter first am not that fast and
 * I am not that good in adaptive actions (which means that it keeps the entries which
 * is really needed and discard the ones that aren’t needed for the longest period based
 * on the access pattern or in other words the request pattern)
 *
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/13/11 9:16 PM
 */
public class LeastFrequentlyUsed<K, V> implements Cache<K, V> {

    private final int CAPASITY = 10;

    //fix replace PriorityQueue by LinkedList because behaviour
    //of PriorityQueue is very unpredictable, ordering and sorting works not correctly, I don't know why
    //So PriorityQueue(implemented like binaryTree) provides O(log n) time for offer, poll, remove(), and add.
    private LinkedList<CountKey<K>> queue = new LinkedList<CountKey<K>>();

    private Map<K, CountKey<K>> keys = new HashMap<K, CountKey<K>>(CAPASITY);
    private Map<K, V> map = new HashMap<K, V>();

    public LeastFrequentlyUsed() {
    }

    @Override
    public V put(K key, V value) {
        if (keys.size() < CAPASITY) {

            addKey(key, value);

        } else {

            replaceKey(key, value);
        }
        return null;
    }

    private void addKey(K key, V value) {
        CountKey<K> countKey = new CountKey<K>(key);
        keys.put(key, countKey);
        map.put(key, value);
        queue.offer(countKey);
    }

    /**
     * //replacement policy
     *
     * @param key   key
     * @param value value
     */
    private void replaceKey(K key, V value) {
        CountKey<K> countKey = queue.poll();
        keys.remove(countKey.getKey());
        map.remove(countKey.getKey());
        addKey(key, value);
    }

    @Override
    public V get(K key) {
        CountKey countKey = keys.get(key);

        if (countKey != null) {  //cache hit
            countKey.incrementCount();
            Collections.sort(queue);//. = new PriorityQueue<CountKey<K>>(keys.values());
            return map.get(key);
        }
        return null;
    }

    @Override
    public List<K> getAllKeys() {
        List<K> l = new ArrayList<K>(CAPASITY);

        for (CountKey<K> countKey : queue) {
            l.add(countKey.getKey());
        }
        return l;
    }
}
