package thread.caches.lru2;

import thread.caches.Cache;

import java.util.*;

/**
 * Least Recently Used 2(LRU2):
 * <p/>
 * I am Least recently used 2, some people calls me least recently used twice which I like it more,
 * I add entries to the cache the second time they are accessed (it requires two times in order to place an entry in
 * the cache);
 * when the cache is full, I remove the entry that has a second most recent access. Because of the need to track
 * the two most recent accesses,
 * access overhead increases with cache size, If I am applied to a big cache size, that would be a problem, which
 * can be a disadvantage.
 * In addition, I have to keep track of some items not yet in the cache (they aren’t requested two times yet).I am better
 * that LRU and
 * I am also adoptive to access patterns.
 *
 * @author Sergiy Doroshenko
 *         email:webserg@gmail.com
 *         Date: 1/20/11 11:30 AM
 */
public class LeastRecentlyUsed2<K, V> implements Cache<K, V> {
    private final int CAPASITY = 10;
    private LinkedList<K> firstEntryQueue = new LinkedList<K>();  //first entry hit
    private LinkedList<K> queue2 = new LinkedList<K>(); //actually cache firstEntryQueue
    private Map<K, V> map = new HashMap<K, V>();  //storage for cache

    @Override
    public V put(K key, V value) {
        if(key == null || value == null ) throw new IllegalArgumentException();
        if (queue2.size() < CAPASITY) {

            addKey(key, value);

        } else {

            replaceKey(key, value);
        }
        return null;
    }

    /**
     * @param key   key
     * @param value value
     */
    private void addKey(K key, V value) {
        if (firstEntryQueue.contains(key)) { //second hit
            queue2.offer(key);
            map.put(key, value);
            firstEntryQueue.remove(key);
        } else {  // first hit putting to firstEntryQueue
            replacementPolicyForFirstEntryQueue(key);
        }
    }

    private void replacementPolicyForFirstEntryQueue(K key) {
        if(firstEntryQueue.size() < CAPASITY){
            firstEntryQueue.offer(key);
        }else{
            firstEntryQueue.poll();   //replacement policy for first entry queue
            firstEntryQueue.offer(key);
        }
    }

    /**
     * @param key key
     */
    private void hit(K key) {
        queue2.remove(key);
        queue2.offer(key);
    }


    /**
     * //replacement policy
     *
     * @param key   key
     * @param value value
     */
    private void replaceKey(K key, V value) {
        if(firstEntryQueue.contains(key)){
            //replacement policy second level queue
            K oldKey = queue2.poll();
            map.remove(oldKey);
            queue2.offer(key);
            map.put(key, value);
            firstEntryQueue.remove(key);
        }else{
            replacementPolicyForFirstEntryQueue(key);
        }
    }



    @Override
    public V get(K key) {
        V v = map.get(key);
        if (v != null) {
            hit(key); //whenever an item is accessed, I place at the top.
        }
        return v;
    }

    @Override
    public List<K> getAllKeys() {
        List<K> l = new ArrayList<K>(queue2);
        return l;
    }
}
