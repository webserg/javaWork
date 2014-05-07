package thread.caches.lru;

import thread.caches.Cache;
import thread.caches.lfu.CountKey;

import java.util.*;

/**
 * I am Least Recently Used cache algorithm; I remove the least recently used items first.
 * The one that wasn’t used for a longest time.
 * <p/>
 * I require keeping track of what was used when, which is expensive if one wants to make sure that
 * I always discards the least recently used item.
 * Web browsers use me for caching. New items are placed into the top of the cache.
 * When the cache exceeds its size limit, I will discard items from the bottom. The trick is that whenever an item
 * is accessed, I place at the top.
 * <p/>
 * So items which are frequently accessed tend to stay in the cache. There are two ways to implement
 * me either an array or a linked list (which will have the least recently used entry at the back and the recently
 * used at the front).
 * <p/>
 * I am fast and I am adaptive in other words I can adopt to data access pattern, I have a large family which
 * completes me and they are even better than me (I do feel jealous some times but it is ok)
 * some of my family member are (LRU2 and 2Q) (they were implemented in order to improve LRU caching
 *
 * @author Sergiy Doroshenko
 *         email:webserg@gmail.com
 *         Date: 1/20/11 11:30 AM
 */
public class LeastRecentlyUsed<K, V> implements Cache<K, V> {
    private final int CAPASITY = 10;
    private LinkedList<K> queue = new LinkedList< >();
    private Map<K, V> map = new HashMap< >();

    @Override
    public V put(K key, V value) {
         if (queue.size() < CAPASITY) {

            addKey(key,value);

        } else {

            replaceKey(key,value);
        }
        return null;
    }

    /**
     *
     * @param key   key
     * @param value    value
     */
    private void addKey(K key, V value) {
        queue.offer(key);
        map.put(key, value);
    }

    /**
     *
     * @param key   key
     */
    private void hit(K key) {
            queue.remove(key);
            queue.offer(key);
    }


    /**
     * //replacement policy
     * @param key key
     * @param value  value
     */
    private void replaceKey(K key, V value) {
        K oldKey = queue.poll();
        map.remove(oldKey);
        queue.offer(key);
        map.put(key,value);
    }

    @Override
    public V get(K key) {
        V v =  map.get(key);
        if(v != null){
             hit(key); //whenever an item is accessed, I place at the top.
        }
        return v;
    }

    @Override
    public List<K> getAllKeys() {
        List<K> l = new ArrayList< >(queue);
        return l;
    }
}
