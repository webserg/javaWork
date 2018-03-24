package thread.producerConsumer;

/**
 * User: Sergiy Doroshenko
 * Date: 12/30/10 3:42 PM
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

/**
 * we have two threads
 * producer consumer pattern
 * <p/>
 * using BlockingQueue version
 * <p/>
 * Useless
 */
public class TwoThreadsUsingListOneByOne2 {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10, true);
        Runnable producer = () -> {
            int i = 0;
            while (true) {
                if (i == 10) i = 0;
                boolean res = queue.offer(i++ + "");
                System.out.println("added " + i + " is " + res + ";size = " + queue.size());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable consumer = () -> {
            while (true) {
                System.out.println("use " + queue.poll());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(producer);
        Executors.newSingleThreadExecutor().execute(consumer);
    }

}
