package collections.queue.arrayBlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by webserg on 13.05.2014.
 */
class Producer implements Runnable {
    private final BlockingQueue queue;
    Random random = new Random();

    Producer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                Object o = produce();
                queue.put(produce());
                System.out.println("producer = " + o.toString() + " ; queue size = " + queue.size());
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    Object produce() {
        return random.nextInt(100);
    }
}

class Consumer implements Runnable {
    private final BlockingQueue queue;

    Consumer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("consumer started.... ");
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    void consume(Object x) {
        System.out.println("consume = " + x.toString() + "; queue size = " + queue.size());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }
}

public class ArrayBlockingQueueUsing {
    public static void main(String[] args) {
        BlockingQueue q = new ArrayBlockingQueue(100);
        Producer p = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}
