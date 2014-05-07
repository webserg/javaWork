package thread.sharedState;

import java.math.BigInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by webserg on 12.04.2014.
 */
public class FibReadWriteLock implements FibonacciGenerator<BigInteger> {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private BigInteger curr = BigInteger.ONE;
    private BigInteger next = BigInteger.ONE;

    @Override
    public BigInteger next() {
        BigInteger result;
        lock.writeLock().lock();
        try {
            // Вход другим потокам запрещен
            result = curr;
            curr = next;
            next = result.add(next);
            return result;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public BigInteger val() {
        lock.readLock().lock();
        try {
            // При отпущенном write lock
            // Допуст`им вход множества потоков
            return curr;
        } finally {
            lock.readLock().unlock();
        }
    }
}
