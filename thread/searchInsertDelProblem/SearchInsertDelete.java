package thread.searchInsertDelProblem;

import collections.lists.SinglyLinkedList;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by webserg on 11.05.2014.
 * Three kinds of threads share access to a singly-linked list:
 * searchers, inserters and deleters. Searchers merely examine the list;
 * hence they can execute concurrently with each other. Inserters add
 * new items to the end of the list; insertions must be mutually exclusive
 * to preclude two inserters from inserting new items at about
 * the same time. However, one insert can proceed in parallel with
 * any number of searches. Finally, deleters remove items from anywhere
 * in the list. At most one deleter process can access the list at
 * a time, and deletion must also be mutually exclusive with searches
 * and insertions.
 */
public class SearchInsertDelete {
    Semaphore insertMutex = new Semaphore(1);
    Semaphore deleteMutex = new Semaphore(1);
    Semaphore searcherMutex = new Semaphore(1);
    AtomicInteger searcherCounter = new AtomicInteger(0);

    static void nap() {
        try {
            Thread.sleep(500); // avoid starvation
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        for (int i = 0; i <= 10; i++)
            singlyLinkedList.insert(i);

        SearchInsertDelete obj = new SearchInsertDelete();
        Runnable searcher = () -> {
            Random random = new Random();
            while (true) {
                if (obj.searcherCounter.get() == 0) {
                    try {
                        obj.searcherMutex.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.searcherCounter.getAndIncrement();
                int k = random.nextInt(10);
                boolean res = singlyLinkedList.search(k);

                System.out.println("search " + k + "res = " + res);

                obj.searcherCounter.getAndDecrement();
                if (obj.searcherCounter.get() == 0) {
                    obj.searcherMutex.release();
                }
//                System.out.println("searcher count = " + obj.searcherCounter.get());
                nap();
            }
        };
        Runnable inserter = () -> {
            Random random = new Random();
            while (true) {
                try {
                    obj.insertMutex.acquire();
                    int k = random.nextInt(10);
                    singlyLinkedList.insert(k);
                    System.out.println("inserter " + k);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.insertMutex.release();
                }
                nap();
            }
        };
        Runnable deleter = () -> {
            Random random = new Random();
            while (true) {
                try {
                    obj.deleteMutex.acquire();
                    obj.insertMutex.acquire();
                    obj.searcherMutex.acquire();
                    System.out.println(singlyLinkedList.toString());
                    int k = random.nextInt(10);
                    boolean res = singlyLinkedList.delete(k);
                    System.out.println("delete " + k + "res = " + res);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    obj.searcherMutex.release();
                    obj.insertMutex.release();
                    obj.deleteMutex.release();
                }
                nap();
            }
        };
        new Thread(inserter).start();
        new Thread(searcher).start();
//        new Thread(searcher).run();
//        new Thread(searcher).run();
//        new Thread(searcher).run();
//        new Thread(searcher).run();
//        new Thread(searcher).run();
//        new Thread(searcher).run();
//        new Thread(inserter).run();
//        new Thread(inserter).run();
//        new Thread(deleter).run();
//        new Thread(deleter).run();
        Executors.newSingleThreadExecutor().execute(searcher);
        Executors.newSingleThreadExecutor().execute(searcher);
        Executors.newSingleThreadExecutor().execute(searcher);
        Executors.newSingleThreadExecutor().execute(searcher);
        Executors.newSingleThreadExecutor().execute(searcher);
        Executors.newSingleThreadExecutor().execute(inserter);
        Executors.newSingleThreadExecutor().execute(inserter);
        Executors.newSingleThreadExecutor().execute(inserter);
        Executors.newSingleThreadExecutor().execute(deleter);
        Executors.newSingleThreadExecutor().execute(deleter);
    }
}
