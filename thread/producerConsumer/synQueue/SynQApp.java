package thread.producerConsumer.synQueue;

import java.util.*;
import java.util.concurrent.*;

/**
 * SynchronousQueue is an interesting creature, according to the Javadoc:
A blocking queue in which each insert operation must wait for a corresponding remove operation by another thread,
 and vice versa. A synchronous queue does not have any internal capacity, not even a capacity of one.
Essentially, SynchronousQueue is another implementation of the aforementioned BlockingQueue. It gives us an extremely
 lightweight way to exchange single elements from one thread to another, using the blocking semantics
 */
class Producer implements Runnable {
    private BlockingQueue<String> drop;
    List<String> messages = Arrays.asList(
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "Wouldn't you eat ivy too?");

    public Producer(BlockingQueue<String> d) {
        this.drop = d;
    }

    public void run() {
        try {
            for (String s : messages)
                drop.put(s);
            drop.put("DONE");
        } catch (InterruptedException intEx) {
            System.out.println("Interrupted! " +
                    "Last one out, turn out the lights!");
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<String> drop;

    public Consumer(BlockingQueue<String> d) {
        this.drop = d;
    }

    public void run() {
        try {
            String msg = null;
            while (!((msg = drop.take()).equals("DONE")))
                System.out.println(msg);
        } catch (InterruptedException intEx) {
            System.out.println("Interrupted! " +
                    "Last one out, turn out the lights!");
        }
    }
}

public class SynQApp {
    public static void main(String[] args) {
        BlockingQueue<String> drop = new SynchronousQueue<String>();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
