package thread.producerConsumer;

/**
 * User: Sergiy Doroshenko
 * Date: 1/3/11 12:04 AM
 */

/**
 * In the producer-consumer code in exercise 1,
 * the producer thread quickly fills the buffer
 * with characters and then waits for the consumer
 * to consume some characters from the buffer.
 * The problem is that the producer waits inside
 * the monitor associated with the buffer, preventing
 * the consumer to execute the synchronized Get method on the buffer
 *
 * decision remove synchronized before methods
 * OR
 * We really want the Producer
 * to release the monitor if the buffer becomes
 * full and allow the Consumer to proceed.
 * Similarly, the Consumer must release the monitor
 * if the buffer becomes empty and allow the Producer to proceed.
 * To coordinate the two threads, we must use the Object's wait() and notify or notifyAll() methods.
 */
class PC {
    public static void main(String[] args) {
        Buffer b = new Buffer(4);
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        p.start();
        c.start();
    }
}

class Buffer {
    private char[] buffer;
    volatile private int count = 0, in = 0, out = 0;

    Buffer(int size) {
        buffer = new char[size];
    }

    public synchronized void Put(char c) {
        while (count == buffer.length) ;
        System.out.println("Producing " + c + " ...");
        buffer[in] = c;
        in = (in + 1) % buffer.length;
        count++;
    }

    public synchronized char Get() {
        while (count == 0) ;
        char c = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        System.out.println("Consuming " + c + " ...");
        return c;
    }
}


class Producer extends Thread {
    private Buffer buffer;

    Producer(Buffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.Put((char) ('A' + i % 26));
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;

    Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.Get();
        }
    }
}
