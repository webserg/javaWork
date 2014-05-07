package thread.caches.lru;

import thread.caches.Cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * LRU Cache. LRU stands for "Least Recently Used",
 * which refers to the policy of removing the oldest,
 * or least-recently used entries to make space for new data.
 * LRU caches have a maximum number of data items that they
 * will hold and these items are usually arranged in a list.
 * When an item is added to the cache, and every time it is accessed
 * after that, it is automatically moved to the head of the list. If the
 * cache is full and a slot is required for a new item, the cache makes room by discarding
 * the entry at the tail of the list - the least-recently used item.
 * <p/>
 * User: webserg
 * Date: 16.12.12
 */
public class LinkedListLRUCache<K,V> extends LinkedHashMap<K,V> implements Cache<K,V> {
    private final int capacity;

    public LinkedListLRUCache(int capacity) {
        super(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    @Override
    public List<K> getAllKeys() {
        return  new ArrayList< >(keySet());
    }
}
