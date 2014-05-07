package collections.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 22, 2010
 * Time: 12:50:22 PM
 */
public class BlockingQueueUsing {
    public static void main(String[] args) {
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>(5);
        Runnable producer = new Producer("Producer", deque);
        Runnable consumer = new Customer("Consumer", deque);
        new Thread(producer).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(consumer).start();
    }
}
