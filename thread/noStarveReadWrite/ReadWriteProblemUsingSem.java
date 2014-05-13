package thread.noStarveReadWrite;

import thread.readWriteProblem.UseList;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The next classical problem, called the Reader-Writer Problem, pertains to any
 * situation where a data structure, database, or file system is read and modified
 * by concurrent threads. While the data structure is being written or modified
 * it is often necessary to bar other threads from reading, in order to prevent a
 * reader from interrupting a modification in progress and reading inconsistent or
 * invalid data.
 * As in the producer-consumer problem, the solution is asymmetric. Readers
 * and writers execute different code before entering the critical section. The
 * synchronization constraints are:
 * 1. Any number of readers can be in the critical section simultaneously.
 * 2. Writers must have exclusive access to the critical section.
 * In other words, a writer cannot enter the critical section while any other
 * thread (reader or writer) is there, and while the writer is there, no other thread
 * may enter.
 * The exclusion pattern here might be called categorical mutual exclusion.
 * A thread in the critical section does not necessarily exclude other threads, but
 * the presence of one category in the critical section excludes other categories.
 * Puzzle: Use semaphores to enforce these constraints, while allowing readers
 * and writers to access the data structure, and avoiding the possibility of deadlock.
 * <p>
 * Starvation
 * <p>
 * In the previous solution, is there any danger of deadlock? In order for a deadlock
 * to occur, it must be possible for a thread to wait on a semaphore while holding
 * another, and thereby prevent itself from being signaled.
 * In this example, deadlock is not possible, but there is a related problem that
 * is almost as bad: it is possible for a writer to starve.
 * If a writer arrives while there are readers in the critical section, it might wait
 * in queue forever while readers come and go. As long as a new reader arrives
 * before the last of the current readers departs, there will always be at least one
 * reader in the room.
 * <p>
 * using wait semafore version
 */
class ReadWriteProblemUsingSem {
    final UseList useList = new UseList();

    final Semaphore write = new Semaphore(1);
    final Semaphore read = new Semaphore(1);

    AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        final ReadWriteProblemUsingSem obj = new ReadWriteProblemUsingSem();
        for (int i = 0; i <= 3; i++) {
            obj.useList.list.add(i);
        }
        Runnable reader = () -> {
            while (true) {
                int tmp = obj.counter.getAndIncrement();
                if (tmp == 0) {
                    try {
                        obj.read.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int s = obj.useList.list.size();
                for (int i = 0; i < s; i++) {
                    System.out.println(" reader = " + Thread.currentThread().getId() + "; value = " + obj.useList.list.get(i));
                }

                tmp = obj.counter.decrementAndGet();
                if (tmp == 0)
                    obj.read.release();
                 System.out.println(tmp);
//                try {
//                    Thread.sleep(50); // avoid starvation
//                } catch (InterruptedException e) {
//                }
            }
        };
        Runnable writer = () -> {
            while (true) {

                try {
                    obj.write.acquire();
                    obj.read.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int s = obj.useList.list.size();
                int k = obj.useList.list.get(s - 1);
                for (int i = 0; i < s; i++) {
                    obj.useList.list.set(i, i + k);
                    System.out.println(" writer = " + Thread.currentThread().getId() + "; value = " + (i + k));
                }
                obj.read.release();
                obj.write.release();
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                }
            }

        };

        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(writer);
        Executors.newSingleThreadExecutor().execute(writer);

    }
}
