package thread.concurrencyInPractice.tests;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.Semaphore;

/**
 * BoundedBuffer
 * <p/>
 * Bounded buffer using \Semaphore
 * * Bounded buffer using condition queues
 * BoundedBuffer implements a fixed-length array-based queue with blocking put and take methods
 * controlled by a pair of counting semaphores. The availableItems semaphore represents the
 * number of elements that can be removed from the buffer, and is initially zero (since the buffer is
 * initially empty). Similarly, availableSpaces represents how many items can be inserted into the
 * buffer, and is initialized to the size of the buffer.
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class SemaphoreBoundedBufferImpl<E> extends BaseBoundedBuffer<E> {
    private final Semaphore availableItems, availableSpaces;
    E[] items;
    @GuardedBy("this")
    private int putPosition = 0, takePosition = 0;

    public SemaphoreBoundedBufferImpl(int capacity) {
        super(capacity);
        if (capacity <= 0)
            throw new IllegalArgumentException();
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(capacity);
    }

    public boolean isEmptyImpl() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFullImpl() {
        return availableSpaces.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException {
        availableSpaces.acquire();
        doInsert(x);
        availableItems.release();
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = doExtract();
        availableSpaces.release();
        return item;
    }

    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;
    }

    private synchronized E doExtract() {
        int i = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return x;
    }
}
