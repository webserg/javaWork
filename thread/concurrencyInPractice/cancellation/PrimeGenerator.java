package thread.concurrencyInPractice.cancellation;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * PrimeGenerator
 * <p/>
 * Using a volatile field to hold cancellation state
 * <p/>
 * Getting tasks and threads to stop safely, quickly, and reliably is not always easy. Java does not
 * provide any mechanism for safely forcing a thread to stop what it is doing.[1] Instead, it provides
 * interruption, a cooperative mechanism that lets one thread ask another to stop what it is doing.
 * <p/>
 * The cooperative approach is required because we rarely want a task, thread, or service to stop
 * immediately, since that could leave shared data structures in an inconsistent state. Instead, tasks
 * and services can be coded so that, when requested, they clean up any work currently in progress
 * and then terminate. This provides greater flexibility, since the task code itself is usually better
 * able to assess the cleanup required than is the code requesting cancellation.
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class PrimeGenerator implements Runnable {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList< >();
    private volatile boolean cancelled;

    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList< >(primes);
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        exec.execute(generator);
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }

    @Test
    public void testASecondOfPrimes() {
        try {
            System.out.println(aSecondOfPrimes());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
