package thread.producerConsumer;

/**
 * User: Sergiy Doroshenko
 * Date: 1/3/11 12:04 AM
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * In the producer-consumer code in exercise 1,
 * the producer thread quickly fills the buffer
 * with characters and then waits for the consumer
 * to consume some characters from the buffer.
 * The problem is that the producer waits inside
 * the monitor associated with the buffer, preventing
 * the consumer to execute the synchronized Get method on the buffer
 * <p/>
 * decision remove synchronized before methods
 * OR
 * We really want the Producer
 * to release the monitor if the buffer becomes
 * full and allow the Consumer to proceed.
 * Similarly, the Consumer must release the monitor
 * if the buffer becomes empty and allow the Producer to proceed.
 * To coordinate the two threads, we must use the Object's wait() and notify or notifyAll() methods.
 */
class PC2 {
    public static void main(String[] args) {
        Buffer2 b = new Buffer2(4);
        Producer2 p = new Producer2(b);
        Consumer2 c = new Consumer2(b);

        ExecutorService exProd = Executors.newSingleThreadExecutor();
        exProd.execute(p);

        ExecutorService exCust = Executors.newSingleThreadExecutor();
        exCust.execute(c);
        ExecutorService exCust2 = Executors.newSingleThreadExecutor();
        exCust2.execute(c);

        exCust.shutdown();
        exCust2.shutdown();
        exProd.shutdown();

    }
}

class Buffer2 {
    private char[] buffer;
    private int count = 0, in = 0, out = 0;

    Buffer2(int size) {
        buffer = new char[size];
    }

    public synchronized void Put(char c) {
        while (count == buffer.length) {
            try {
                wait();
            } catch (InterruptedException e) {
            } finally {
            }
        }
        System.out.println("Producing " + c + " ...");
        buffer[in] = c;
        in = (in + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized char Get() {
        while (count == 0) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting");
                wait();
            } catch (InterruptedException e) {
            } finally {
            }
        }
        char c = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        System.out.println("Consuming " + c + " ..." + Thread.currentThread().getName());
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        return c;
    }
}


class Producer2 implements Runnable {
    private Buffer2 buffer;

    Producer2(Buffer2 b) {
        buffer = b;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.Put((char) ('A' + i % 26));
        }
    }
}

class Consumer2 implements Runnable {
    private Buffer2 buffer;

    Consumer2(Buffer2 b) {
        buffer = b;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.Get();
        }
    }
}
