package collections.queue;

import java.util.concurrent.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * User: Sergiy Doroshenko
 * Date: 12/17/10 5:50 PM
 */
//SynchronousQueue will allow an insert into the queue only if there is a thread waiting to consume it
public class SynchronousQueueApp {
    public static void main(String[] args) {
        BlockingDeque<Integer> deque = new  LinkedBlockingDeque<Integer>();
        Runnable producer = new Producer("Producer", deque);
        Runnable consumer = new Customer("Consumer", deque);
        new Thread(producer).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(consumer).start();
    }
}
