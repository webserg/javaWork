package thread.littleBookOfSemafore.readWriteProblem;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * we have several threads to read
 * and two thread for write
 * <p>
 * <p>
 * using wait notify version
 */
class RWProblemUsingRWLock {
    final UseList useList = new UseList();


    ReadWriteLock rwLock = new ReentrantReadWriteLock();


    public static void main(String[] args) throws InterruptedException {

        final RWProblemUsingRWLock obj = new RWProblemUsingRWLock();
        for (int i = 0; i <= 3; i++) {
            obj.useList.list.add(i);
        }
        Runnable reader = () -> {
            while (true) {
                try {
                    obj.rwLock.readLock().lock();

                    int s = obj.useList.list.size();
                    for (int i = 0; i < s; i++) {
                        System.out.println(" reader = " + Thread.currentThread().getId() + "; value = " + obj.useList.list.get(i));
                    }
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                    }
                } finally {
                    obj.rwLock.readLock().unlock();
                }

            }
        };
        Runnable writer = () -> {
            while (true) {
                try {
                    obj.rwLock.writeLock().lock();
                    int s = obj.useList.list.size();
                    int k = obj.useList.list.get(s - 1);
                    for (int i = 0; i < s; i++) {
                        obj.useList.list.set(i, i + k);
                        System.out.println(" writer = " + Thread.currentThread().getId() + "; value = " + (i + k));
                    }
                    try {
                        Thread.sleep(1); // avoid starvation
                    } catch (InterruptedException e) {
                    }
                } finally {
                    obj.rwLock.writeLock().unlock();
                }
            }

        };

        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(writer);
        Executors.newSingleThreadExecutor().execute(writer);

    }
}

