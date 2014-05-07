package thread.concurrencyInPractice.barriers.cache;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
