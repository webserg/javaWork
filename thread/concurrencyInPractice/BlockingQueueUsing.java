package thread.concurrencyInPractice;
//http://web.mit.edu/6.005/www/fa15/classes/22-queues/

/**
 *
 * Message passing with threads
 * We’ve previously talked about message passing between processes: clients and servers communicating over network sockets. We can also use message passing between threads within the same process, and this design is often preferable to a shared memory design with locks.
 *
 * Use a synchronized queue for message passing between threads. The queue serves the same function as the buffered network communication channel in client/server message passing. Java provides the BlockingQueue interface for queues with blocking operations:
 *
 * In an ordinary Queue:
 *
 * add(e) adds element e to the end of the queue.
 * remove() removes and returns the element at the head of the queue, or throws an exception if the queue is empty.
 * A BlockingQueue extends this interface:
 *
 * additionally supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element.
 *
 * put(e) blocks until it can add element e to the end of the queue (if the queue does not have a size bound, put will not block).
 * take() blocks until it can remove and return the element at the head of the queue, waiting until the queue is non-empty.
 * When you are using a BlockingQueue for message passing between threads, make sure to use the put() and take() operations, not add() and remove().
 *
 * producer-consumer message passing
 * Analogous to the client/server pattern for message passing over a network is the producer-consumer design pattern for message passing between threads. Producer threads and consumer threads share a synchronized queue. Producers put data or requests onto the queue, and consumers remove and process them. One or more producers and one or more consumers might all be adding and removing items from the same queue. This queue must be safe for concurrency.
 *
 * Java provides two implementations of BlockingQueue:
 *
 * ArrayBlockingQueue is a fixed-size queue that uses an array representation. putting a new item on the queue will block if the queue is full.
 * LinkedBlockingQueue is a growable queue using a linked-list representation. If no maximum capacity is specified, the queue will never fill up, so put will never block.
 * Unlike the streams of bytes sent and received by sockets, these synchronized queues (like normal collections classes in Java) can hold objects of an arbitrary type. Instead of designing a wire protocol, we must choose or design a type for messages in the queue. It must be an immutable type. And just as we did with operations on a threadsafe ADT or messages in a wire protocol, we must design our messages here to prevent race conditions and enable clients to perform the atomic operations they need.
 *
 */

/**
 * thread safe queue, with enqueuing and dequeuing methods which don't
 * return until they have executed succesfuly
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Squares integers.
 */
class Squarer {

    private final BlockingQueue<Integer> in;
    private final BlockingQueue<SquareResult> out;
    // Rep invariant: in, out != null

    /**
     * Make a squarer that will listen for requests and generate replies.
     * @param requests queue to receive requests from
     * @param replies queue to send replies to
     */
    public Squarer(BlockingQueue<Integer> requests, BlockingQueue<SquareResult> replies) {
        this.in = requests;
        this.out = replies;
    }

    /**
     * Start handling squaring requests.
     */
    public void start() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // TODO: we may want a way to stop the thread
                    try {
                        // block until a request arrives
                        int x = in.take();
                        // compute the answer and send it back
                        int y = x * x;
                        out.put(new SquareResult(x, y));
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

/**
 * An immutable squaring result message.
 */
class SquareResult {
    private final int input;
    private final int output;

    /**
     * Make a new result message.
     * @param input input number
     * @param output square of input
     */
    public SquareResult(int input, int output) {
        this.input = input;
        this.output = output;
    }

    // TODO: we will want more observers, but for now...

    @Override public String toString() {
        return input + "^2 = " + output;
    }
}

public class BlockingQueueUsing {

    /**
     * Create and use a squarer.
     */
    public static void main(String[] args) {

        BlockingQueue<Integer> requests = new LinkedBlockingQueue<>();
        BlockingQueue<SquareResult> replies = new LinkedBlockingQueue<>();

        Squarer squarer = new Squarer(requests, replies);
        squarer.start();

        try {
            // make a request
            requests.put(42);

            // maybe do something concurrently...

            // read the reply
            System.out.println(replies.take());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

