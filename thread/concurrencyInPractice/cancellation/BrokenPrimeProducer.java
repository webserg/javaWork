package thread.concurrencyInPractice.cancellation;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The cancellation mechanism in PrimeGenerator will eventually cause
 * the primeseeking task to exit, but it might take a while. If,
 * however, a task that uses this approach calls a blocking method
 * such as BlockingQueue.put, we could have a more serious problem the
 * task might never check the cancellation flag and therefore might
 * never terminate.
 * <p/>
 * The producer thread generates
 * primes and places them on a blocking queue. If the producer gets ahead of the consumer, the
 * queue will fill up and put will block. What happens if the consumer tries to cancel the producer
 * task while it is blocked in put? It can call cancel which will set the cancelled flagbut the
 * 108
 * producer will never check the flag because it will never emerge from the blocking put (because
 * the consumer has stopped retrieving primes from the queue).
 *
 * @author Sergiy Doroshenko webserg@gmail.com Feb 24, 2009 12:35:09
 *         PM
 */
public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled)    //never checked because put blocked (queue full and waiting for take method)
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
        }
    }

    public void cancel() {
        System.out.println("cancel");
        cancelled = true;
    }

    static void consumePrimes() throws InterruptedException {
        BlockingQueue<BigInteger> primes = new LinkedBlockingQueue<>(11);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
        try {
            for (int i = 0; i < 12; i++) {
                System.out.println(primes.take());
                SECONDS.sleep(1);
            }
        } finally {
            producer.cancel();
        }
        //task never canceled if you don't use take later after cancel
        //because produser never check cancel flag because queue is full
        //and put method will be wating for take method
        //that may be problem
        //System.out.println(primes.take());
    }

    public static void main(String[] args) throws InterruptedException {
        consumePrimes();
    }
}
