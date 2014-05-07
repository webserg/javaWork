package thread.producerConsumer;

/**
 * User: Sergiy Doroshenko
 * Date: 1/3/11 12:04 AM
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

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
class PC3 {
    public static void main(String[] args) {
        Buffer3 b = new Buffer3(4);
        Producer3 p = new Producer3(b);
        Consumer3 c = new Consumer3(b);

        ExecutorService exProd = Executors.newSingleThreadExecutor();
        exProd.execute(p);

        ExecutorService exCust = Executors.newSingleThreadExecutor();
        exCust.execute(c);
        ExecutorService exCust2 = Executors.newSingleThreadExecutor();
        exCust2.execute(c);

        exCust.shutdown();
        exProd.shutdown();
    }
}

class Buffer3 {
    private char[] buffer;
    volatile private int count = 0, in = 0, out = 0;
    private Semaphore semaphore;

    Buffer3(int size) {
        buffer = new char[size];
        semaphore = new Semaphore(1);

    }

    public void Put(char c) {

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (count == 0)
            for (int i = 0; i <= 4; i++) {
                System.out.println("Producing " + c + " ...");
                buffer[in] = c;
                in = (in + 1) % buffer.length;
                count++;
            }
        if (count == buffer.length) {
            semaphore.release();
        }
        try {
            Thread.sleep(400);
        } catch (Exception ex) {
        }
    }

    public void Get() throws InterruptedException {
        semaphore.acquire();
        if (count == buffer.length)
            for (int i = 0; i <= 4; i++) {

                char c = buffer[out];
                out = (out + 1) % buffer.length;
                count--;
                System.out.println("Consuming " + c + " ..." + Thread.currentThread().getName());

            }

        semaphore.release();

        try {
            Thread.sleep(100);
        } catch (Exception ex) {
        }


    }
}


class Producer3 extends Thread {
    private Buffer3 buffer;

    Producer3(Buffer3 b) {
        buffer = b;
    }

    public void run() {
        for (int i = 0; i < 100000; i++) {
            buffer.Put((char) ('A' + i % 26));
        }
    }
}

class Consumer3 extends Thread {
    private Buffer3 buffer;

    Consumer3(Buffer3 b) {
        buffer = b;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.Get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
