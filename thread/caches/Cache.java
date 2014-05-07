package thread.caches;

import java.util.List;

/**
 * First in First out (FIFO):
 * <p/>
 * I am first in first out; I am a low-overhead algorithm I require little effort for managing the cache entries.
 * The idea is that I keep track of all the cache entries in a queue, with the most recent entry at the back,
 * and the earliest entry in the front. When there e is no place and an entry needs to be replaced,
 * I will remove the entry at the front of the queue (the oldest entry) and replaced with the current fetched entry.
 * I am fast but I am not adaptive
 * <p/>
 * -Second Chance:
 * <p/>
 * Hello I am second change I am a modified form of the FIFO replacement algorithm, known as the Second chance
 * replacement algorithm, I am better than FIFO at little cost for the improvement. I work by looking at the
 * front of the queue as FIFO does, but instead of immediately replacing the cache entry (the oldest one), i
 * check to see if its referenced bit is set(I use a bit that is used to tell me if this entry is being used
 * or requested before or no). If it is not set, I will replace this entry. Otherwise, I will clear the referenced bit,
 * and then insert this entry at the back of the queue (as if it were a new entry) I keep repeating this process.
 * You can think of this as a circular queue. Second time I encounter the same entry I cleared its bit before,
 * I will replace it as it now has its referenced bit cleared. am better than FIFO in speed
 *
 * @author Sergiy Doroshenko
 *         Date: 1/13/11 8:55 PM
 */
public interface Cache<KeyType, ValueType> {
    /**
     * Caches the given value under the given key.
     * <p/>
     * If there already is an item under the given key, it will be replaced by the new value. <p>
     *
     * @param key may not be null
     * @param value may be null, in which case the cache entry will be removed (if it existed).
     * @return the previous value, or null if none
     */
    ValueType put(KeyType key, ValueType value);

    /**
     * @param key may not be null
     * @return Returns the value for the given key. Null if there is no value,
     * or if it has expired.
     */
    ValueType get(KeyType key);

    /**
     *
     * @return list
     */
    List<KeyType> getAllKeys();
}
