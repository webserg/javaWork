package thread.ItUniversityCopenhagen.ex2;// Week 2
// Counting primes, using multiple threads for better performance.
// (Much simplified from CountprimesMany.java)
// sestoft@itu.dk * 2014-08-27

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class TestCountPrimes {
    public static void main(String[] args) {
        final int range = 10_000_000;
//        System.out.printf("Sequential result: %10d%n%n", countSequential(range));
//        System.out.printf("Parallel2  result: %10d%n%n", countParallel2(range / 2));
//        System.out.printf("Parallel4  result: %10d%n%n", countParallelN(range, 4));
//        System.out.printf("Parallel10 result: %10d%n%n", countParallelN(range, 10));
        System.out.printf("Parallel10 result: %10d%n%n", countParallelForkJoin(range));
    }

    public static boolean isPrime(int n) {
        int k = 2;
        while (k * k <= n && n % k != 0)
            k++;
        return n >= 2 && k * k > n;
    }

    public static boolean isPrimeNumber(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    // Sequential solution
    private static long countSequential(int range) {
        long count = 0;
        final int from = 0, to = range;
        for (int i = from; i < to; i++)
            if (isPrimeNumber(i))
                count++;
        return count;
    }

    // Basic parallel solution, using 2 threads
    private static long countParallel2(int perThread) {
        final LongCounter lc = new LongCounter();
        final int from1 = 0, to1 = perThread;
        Thread t1 = new Thread(() -> {
            {
                for (int i = from1; i < to1; i++)
                    if (isPrimeNumber(i))
                        lc.increment();
            }
        });
        final int from2 = perThread, to2 = perThread * 2;
        Thread t2 = new Thread(() -> {
            {
                for (int i = from2; i < to2; i++)
                    if (isPrimeNumber(i))
                        lc.increment();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException exn) {
        }
        return lc.get();
    }

    // General parallel solution, using multiple threads
    private static long countParallelN(int range, int threadCount) {
        final int perThread = range / threadCount;
        final LongCounter lc = new LongCounter();
        Thread[] threads = new Thread[threadCount];
        for (int t = 0; t < threadCount; t++) {
            final int from = perThread * t,
                    to = (t + 1 == threadCount) ? range : perThread * (t + 1);
            threads[t] = new Thread(() -> {
                {
                    for (int i = from; i < to; i++)
                        if (isPrimeNumber(i))
                            lc.increment();
                }
            });
        }
        for (int t = 0; t < threadCount; t++)
            threads[t].start();
        try {
            for (int t = 0; t < threadCount; t++)
                threads[t].join();
        } catch (InterruptedException exn) {
        }
        return lc.get();
    }

    private static long countParallelForkJoin(int range) {

        // Create a DocumentTask
        PrimeTask task = new PrimeTask(1, range);

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Execute the Task
        pool.execute(task);

//        // Write statistics about the pool
//        do {
//            System.out.printf("******************************************\n");
//            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
//            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
//            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
//            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
//            System.out.printf("******************************************\n");
//
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        } while (!task.isDone());

        // Shutdown the pool
        pool.shutdown();

        // Wait for the finalization of the tasks
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Write the results of the tasks
        try {
            return task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();

        }
        return 0;
    }
}

class LongCounter {
    private long count = 0;

    public synchronized void increment() {
        count = count + 1;
    }

    public synchronized long get() {
        return count;
    }
}

class PrimeTask extends RecursiveTask<Integer> {
    private int from, to;

    public PrimeTask(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        Integer result = 0;
        if (to - from < 1000) {
            for (int i = from; i < to; i++) {
                if (TestCountPrimes.isPrimeNumber(i)) {
                    result++;
                }
            }

        } else {
            int mid = (from + to) / 2;
            PrimeTask task1 = new PrimeTask(from, mid);
            PrimeTask task2 = new PrimeTask(mid, to);
            invokeAll(task1, task2);
            try {
                result = groupResults(task1.get(), task2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer groupResults(Integer number1, Integer number2) {
        Integer result;

        result = number1 + number2;
        return result;
    }
}
