package thread.caches.cachemap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sergiy Doroshenko
 *         Dec 11, 2008 4:44:15 PM
 */
public class CashMapImpl<K, V> implements CacheMap<K, V> {
    private Map<K, V> map = new HashMap<K, V>();

    private Map<K, Long> time = new ConcurrentHashMap<K, Long>();

    private long timeToLive;

    @Override
    public void clear() {
        time.clear();
        map.clear();
    }

    @Override
    public void clearExpired() {
        for (Map.Entry<K, Long> entry : time.entrySet()) {
            if (entry.getValue() < Clock.getTime()) {
                time.remove(entry.getKey());
                map.remove(entry.getKey());
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        if (!time.containsKey(key) || time.get(key) < Clock.getTime())
            return false;
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        if (map.containsValue(value)) {
            clearExpired();
        }
        return map.containsValue(value);
    }

    @Override
    public V get(K key) {
        if (time.get(key) == null || time.get(key) < Clock.getTime())
            return null;
        return map.get(key);
    }

    @Override
    public long getTimeToLive() {
        return timeToLive;
    }

    @Override
    public boolean isEmpty() {
        clearExpired();
        return map.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        if (time.get(key) == null || time.get(key) < Clock.getTime()) {
            time.put(key, Clock.getTime() + timeToLive);
            map.put(key, value);
            return null;
        }
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        if (time.get(key) == null || time.get(key) < Clock.getTime())
            return null;

        time.remove(key);
        return map.remove(key);

    }

    @Override
    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    @Override
    public int size() {
        clearExpired();
        return map.size();
    }

    @Override
    public List<K> getAllKeys() {
        return null;
    }
}
