package thread.concurrencyInPractice.tests;

public interface BoundedBufferI<V> {
    void put(V v) throws InterruptedException;
    V take() throws InterruptedException;
    boolean isEmpty();
    boolean isFull();

}
