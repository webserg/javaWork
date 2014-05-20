package collections.queue.arrayBlockingQueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by webserg on 14.05.2014.
 */
public class MyArrayBlockingQueueUsing {

    public static void main(String[] args) {
//        MyArrayBlockingQueue q = new MyArrayBlockingQueue();
        MyArrayBlockingQueueWithLock q = new MyArrayBlockingQueueWithLock();
        Runnable writers = () -> {
            Random randome = new Random();
            while (true) {
                int k = randome.nextInt(100);
                q.put(k);
                System.out.println("put" + k);
            }
        };
        Runnable readers = () -> {
            while (true) {
                System.out.println("take" + q.get());
            }
        };

        ExecutorService readerS = Executors.newFixedThreadPool(5);
        ExecutorService writerS = Executors.newFixedThreadPool(1);
        readerS.submit(readers);
//        readerS.submit(readers);
//        readerS.submit(readers);
//        readerS.submit(readers);
//        readerS.submit(readers);
        writerS.execute(writers);
        readerS.shutdown();
        writerS.shutdown();

    }


}

class MyArrayBlockingQueue {
    int N = 10;
    Integer[] queue = new Integer[N];
    volatile int putIdx, takeIdx, countN = 0;

    void put(Integer t) {
        synchronized (queue) {
            while (countN == N) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                }
            }
            if (putIdx == N - 1) putIdx = 0;
            countN++;
            queue[putIdx++] = t;
            queue.notifyAll();
        }
    }

    Integer get() {
        synchronized (queue) {
            while (countN == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                }
            }
            if (takeIdx == N - 1) takeIdx = 0;
            countN--;

            Integer t = queue[takeIdx++];
            queue.notifyAll();
            return t;
        }
    }
}

class MyArrayBlockingQueueWithLock {
    int N = 10;
    Integer[] queue = new Integer[N];
    volatile int putIdx, takeIdx, countN = 0;
    Lock lock = new ReentrantLock();
    Condition cond = lock.newCondition();


    void put(Integer t) {
        lock.lock();
        try {
            while (countN == N) {
                try {
                    cond.await();
                } catch (InterruptedException e) {
                }
            }
            if (putIdx == N - 1) putIdx = 0;
            countN++;
            queue[putIdx++] = t;
            cond.signalAll();
        } finally {
           lock.unlock();
        }

    }

    Integer get() {
       lock.lock();
        try {
            while (countN == 0) {
                try {
                    cond.await();
                } catch (InterruptedException e) {
                }
            }
            if (takeIdx == N - 1) takeIdx = 0;
            countN--;

            Integer t = queue[takeIdx++];
            cond.signalAll();
            return t;
        } finally {
           lock.unlock();
        }
    }
}