package thread.caches.cachemap;

import thread.caches.Cache;

/**
 * A generic cache. Works just like a Map, except that entries automatically "disappear"
 * when they expire. <p>
 * <p>
 * For example if you have a bunch of persons in a database or external system,
 * and you have a corresponding Person class with id of type Long, you can create a cache
 * with 60-second expiry like this: <p>
 * <pre>
 * CacheMap&lt;Long, Person&gt; cache = new CacheMapImpl&lt;Long, Person&gt;();
 * cache.setTimeToLive(60000);
 * </pre>
 * <p>
 * Your code for fetching a person by id would look something like this: <p>
 * <p>
 * <pre>
 * Person person = cache.get(personId);
 * if (person == null) {
 *   person = slowSystemThatShouldntBeUsedTooOften.getPerson(personId);
 *   cache.put(personId, person);
 * }
 * return person;
 * </pre>
 * <p>
 * Additional notes: <br>
 * <ul>
 * <li>
 * Implementations do not have to be thread-safe.
 * </li>
 * <li>
 * No methods should ever return or count any entries that have expired.
 * </li>
 * <li>
 * Implementations do not have to clear expired entries automatically
 * as soon as they expire.
 * It is OK to clean up expired entries in conjunction with method calls instead.
 * From the outside, however, it should look like entries disappear as soon as they
 * get expired.
 * </li>
 * <li>
 * For unit-testing purposes, this class should get the current time using
 * the Clock class, not System.currentTimeMillis(). That way unit tests can override the
 * time.
 * </li>
 * </ul>
 *
 * @author Henrik Kniberg
 * @see Clock
 */
public interface CacheMap<KeyType, ValueType> extends Cache<KeyType, ValueType> {

    public long getTimeToLive();

    /**
     * Sets how long new entries are kept in the cache. Until this method is called,
     * some kind of default value should apply.
     */
    public void setTimeToLive(long timeToLive);

    /**
     * Clears all expired entries.
     * This is called automatically in conjuction with most operations,
     * but for memory optimization reasons you can call this explicitely at any time.
     */
    public void clearExpired();

    /**
     * Removes all entries.
     */
    public void clear();

    /**
     * Checks if the given key is included in this cache map.
     */
    public boolean containsKey(KeyType key);

    /**
     * Checks if the given value is included in this cache map.
     */
    public boolean containsValue(ValueType value);


    /**
     * True if this cache is empty.
     */
    public boolean isEmpty();

    /**
     * Removes the given key.
     *
     * @param key
     * @return the previous value, if there was any
     */
    public ValueType remove(Object key);

    /**
     * How many entries this cache map contains.
     */
    public int size();

}
