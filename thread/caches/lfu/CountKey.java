package thread.caches.lfu;

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/18/11 12:34 PM
 */
public class CountKey<K> implements Comparable<CountKey> {
    private K key;
    private Integer count = 0;

    public CountKey(K k) {
        this.key = k;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void incrementCount() {
        count++;
    }

    @Override
    public int compareTo(CountKey o) {
        return this.count > o.getCount() ? 1 : this.count < o.getCount() ? -1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountKey countKey = (CountKey) o;

        if (key != null ? !key.equals(countKey.key) : countKey.key != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    public K getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "CountKey{" +
                "key=" + key +
                ", count=" + count +
                '}';
    }
}
