package thread.caches.arc;

import thread.caches.Cache;
import thread.caches.lfu.CountKey;

import java.util.*;

/**
 * I am Adaptive Replacement Cache; some people say that I balance between LRU and LFU, to
 * improve combined result, well that's not 100% true actually
 * I am made from 2 LRU lists, One list, say L1, contains entries that have been seen only once recently,
 * while the other list, say L2, contains
 * entries that have been seen at least twice recently.
 * <p/>
 * The items that have been seen twice within a short time have a low inter-arrival rate, and, hence, are thought of as
 * high-frequency.
 * Hence, we think of L1as capturing recency while L2 as capturing frequency so most of people think I am a balance
 * between LRU and LFU
 * but that is ok I am not angry form that.
 * <p/>
 * I am considered one of the best performance replacement algorithms, Self tuning algorithm and low overhead replacement cache
 * I also keep history of entries equal to the size of the cache location; this is to remember the entries that
 * were removed and it allows me to see
 * if a removed entry should have stayed and we should have chosen another one to remove.(I really have bad memory)And yes
 * I am fast and adaptive.
 * <p/>
 * User: webserg@gmail.com
 * Date: 1/24/11
 */
public class AdaptiveReplacementUsed<K, V> implements Cache<K, V> {
    private final int CAPASITY = 10;

    //contains entries that have been seen only once recently
    private LinkedList<CountKey<K>> queue1 = new LinkedList<CountKey<K>>();

    //other list, say L2, contains
    // entries that have been seen at least twice recently
    private LinkedList<CountKey<K>> queue2 = new LinkedList<CountKey<K>>();

    private Map<K, CountKey<K>> keys = new HashMap<K, CountKey<K>>(CAPASITY);

    private Map<K, V> map = new HashMap<K, V>();

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
        countKey.incrementCount();
        keys.put(key, countKey);
        map.put(key, value);
        queue1.offer(countKey);

    }

    /**
     * //replacement policy
     *
     * @param key   key
     * @param value value
     */
    private void replaceKey(K key, V value) {
        CountKey<K> countKey = queue1.poll();

        if(countKey == null){  //if first queue is empty(there is no key with 1 hit at all)
            countKey = queue2.poll();
        }

        keys.remove(countKey.getKey());
        map.remove(countKey.getKey());
        addKey(key, value);
    }


    @Override
    public V get(K key) {
        CountKey<K> countKey = keys.get(key);

        if (countKey != null) {  //cache hit
            if (countKey.getCount() < 2) {

                moveKeyFromQueue1ToQueue2(countKey);
            }

            countKey.incrementCount();
            if (countKey.getCount() > 2)
                Collections.sort(queue2);

            return map.get(key);
        }
        return null;
    }

    private void moveKeyFromQueue1ToQueue2(CountKey<K> countKey) {
        queue1.remove(countKey);

        if (queue2.size() >= CAPASITY) {
            CountKey<K> oldCountKey = queue2.poll();
            keys.remove(oldCountKey.getKey());
            map.remove(oldCountKey.getKey());
        }

        queue2.offer(countKey);
    }

    @Override
    public List<K> getAllKeys() {
        List<K> l = new ArrayList<K>(queue1.size() + queue2.size());

        for (CountKey<K> countKey : queue1) {
            l.add(countKey.getKey());
        }
        for (CountKey<K> countKey : queue2) {
            l.add(countKey.getKey());
        }
        return l;
    }
}
