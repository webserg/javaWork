package thread.producerConsumer;

/**
 * User: Sergiy Doroshenko
 * Date: 1/1/11 9:28 PM
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;

/**
 * we have two threads
 * one start to fill collection
 * another start to use collection only when first is finish
 * first start work only with empty collection
 * second must work only with full collection
 * <p/>
 * using condition
 */
public class TwoThreadsUsingListOneByOne4 {
    public static void main(String[] args) {
        final Queue<String> list = new LinkedList<String>();
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (list.size() == 0) {

                        for (int i = 0; i < 10; i++) {
                            list.offer(i + "");
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("added " + i);
                        }
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (list.size() == 10) {
                        for (int i = 0; i < 10; i++) {
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("use " + list.poll());
                        }
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Executors.newSingleThreadExecutor().execute(producer);
        Executors.newSingleThreadExecutor().execute(consumer);
    }
}
