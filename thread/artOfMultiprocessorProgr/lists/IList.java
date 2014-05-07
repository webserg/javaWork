package thread.artOfMultiprocessorProgr.lists;

/**
 * User: webserg
 * Date: 01.01.12
 */
public interface IList<T> {
    /**
     * Nonblocking synchronization: Sometimes we can eliminate locks entirely,
     * relying on built-in atomic operations such as compareAndSet() for synchronization.
     *
     * @param item
     * @return
     */
    boolean add(T item);

    /**
     * The remove(x) method removes x from the set, returning true if, and only if
     * x was there.
     *
     * @param item
     * @return
     */

    boolean remove(T item);

    /**
     * The contains(x) returns true if, and only if the set contains x.
     *
     * @param item
     * @return
     */
    boolean contains(T item);
}
