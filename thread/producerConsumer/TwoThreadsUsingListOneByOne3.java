package thread.producerConsumer;

/**
 * User: Sergiy Doroshenko
 * Date: 1/1/11 9:28 PM
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * we have two threads
 * one start to fill collection
 * another start to use collection only when first is finish
 * first start work only with empty collection
 * second must work only with full collection
 * <p/>
 * using Semafore version
 */
public class TwoThreadsUsingListOneByOne3 {
    public static void main(String[] args) {
        final Queue<String> list = new LinkedList<String>();
        final Semaphore sem = new Semaphore(1);
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sem.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 10; i++) {
                        list.offer(i + "");
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("added " + i);
                    }
                    sem.release();
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sem.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("use " + list.poll());
                    }
                    sem.release();
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Executors.newSingleThreadExecutor().execute(producer);
        Executors.newSingleThreadExecutor().execute(consumer);
    }
}
