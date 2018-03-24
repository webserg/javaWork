package thread.caches;

import java.util.List;

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/14/11 3:02 PM
 */
public class UserOfCache {
    private static UserOfCache ourInstance;

    private Cache<KeyObject, ValueObject> cache;
    private List<ValueObject> storage;

    private UserOfCache() {
    }

    private UserOfCache(Cache<KeyObject, ValueObject> cache, List<ValueObject> storage) {
        this.cache = cache;
        this.storage = storage;
    }

    public static void createInstance(Cache<KeyObject, ValueObject> cache, List<ValueObject> storage) {
        if (ourInstance != null) throw new IllegalStateException("instance already created");

        ourInstance = new UserOfCache(cache, storage);
    }

    public static synchronized UserOfCache getInstance() {
        if (ourInstance == null) throw new IllegalStateException("instance hasn't been created yet");
        return ourInstance;
    }

    public static ValueObject get(KeyObject keyObject) {
        if (keyObject == null) throw new IllegalArgumentException();
        ValueObject valueObject = ourInstance.cache.get(keyObject);
        if (valueObject == null) {  // cache miss
            for (ValueObject v : ourInstance.storage) {
                if (v.getKey().equals(keyObject)) {
                    valueObject = v;
                    ourInstance.cache.put(keyObject, valueObject);
                    return valueObject;
                }
            }
        }
        return valueObject;
    }

    public static List<KeyObject> getAllCache() {
        return ourInstance.cache.getAllKeys();
    }

    public static void erase() {
        ourInstance = null;
    }
}
