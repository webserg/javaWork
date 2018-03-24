package thread.ItUniversityCopenhagen.ex2;

import thread.ItUniversityCopenhagen.ex3.Histogram;
import thread.ItUniversityCopenhagen.ex3.Histogram1;
import thread.ItUniversityCopenhagen.ex3.SimpleHistogram;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Now consider again counting the number of prime factors in a number p, as in Exercise 2.3 and file Test-
 * CountFactors.java. Use the Histogram2 class to write a parallel program that counts how many numbers
 * in the range 0. . . 4 999 999 have 0 prime factors, how many have 1 prime factor, how many have 2 prime
 * factors, and so on. You may draw inspiration from the TestCountPrimes.java example.
 * The correct result should look like this:
 * 0: 2
 * 1: 348513
 * 2: 979274
 * 3: 1232881
 * 4: 1015979
 * 5: 660254
 * 6: 374791
 * 7: 197039
 * 8: 98949
 * 9: 48400
 * ... and so on
 * showing that 348 513 numbers in 0. . . 4 999 999 have 1 prime factor (those are the prime numbers), 979 274
 * numbers have 2 prime factors, and so on. (The 2 numbers that have 0 prime factors are 0 and 1). And of
 * course the numbers in the second column should add up to 5 000 000.
 */
class TestCountFactorsConcurrent {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int range = 5000_000;
        final int num = 30;
        String histogram = getSeqHistogram(range, new Histogram1(num));
        System.out.println(histogram);
        String histogram2 = getConcurrentHistogram(range, new Histogram2(num));
        System.out.println(histogram2);
//        String histogram3 = getConcurrentHistogram(range, new Histogram3(num));
//        System.out.println(histogram3);
        String histogram4 = getConcurrentHistogram(range, new Histogram4(num));
        System.out.println(histogram4);
        assert histogram.equals(histogram2);
        assert histogram.equals(histogram4);

    }

    private static String getSeqHistogram(int range, Histogram histogram) {
        for (int i = 0; i < range; i++) {

            int count = countFactors(i);
            histogram.increment(count);

        }

        return SimpleHistogram.dumpToString(histogram);
    }

    private static String getConcurrentHistogram(int range, Histogram histogram) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        final CountDownLatch latch = new CountDownLatch(range);//How to wait for all threads to finish
        int subrange = 0;
        for (int i = 0; i < 10; i++) {
            int startRange = subrange;
            subrange = subrange + range / 10;
            int endRange = subrange;
            executorService.submit(() -> {
                for (int p = startRange; p < endRange; p++) {
                    int count = countFactors(p);
                    histogram.increment(count);
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return SimpleHistogram.dumpToString(histogram);
    }

    public static int countFactors(int p) {
        if (p < 2)
            return 0;
        int factorCount = 1, k = 2;
        while (p >= k * k) {
            if (p % k == 0) {
                factorCount++;
                p /= k;
            } else {
                if (k > 2) k += 2;
                else k += 1;
            }
        }
        return factorCount;
    }
}

class Histogram2 implements Histogram {
    private int[] counts;

    public Histogram2(int span) {
        this.counts = new int[span];
    }

    public synchronized void increment(int item) {
        counts[item] = counts[item] + 1;
    }

    public int getCount(int item) {
        return counts[item];
    }

    public int getSpan() {
        return counts.length;
    }

    @Override
    public synchronized int[] getBuckets() {
        return Arrays.copyOf(counts, counts.length);
    }
}

/**
 * doesn't work
 * <p>
 * AtomicInteger[] will require an object per element. AtomicIntegerArray just requires the AtomicIntegerArray object
 * and an array object. So use the latter if possible.
 * ...but it should also be noted that AtomicInteger[] is not thread safe. Specifically, the array's references
 * to the individual AtomicInteger objects may or may not be correct if accessed from multiple threads.
 * Synchronizing access on the array object itself will eliminate this issue, though.
 */
class Histogram3 implements Histogram {
    private AtomicInteger[] counts;

    public Histogram3(int span) {
        this.counts = new AtomicInteger[span];
    }

    public void increment(int item) {
        counts[item].getAndIncrement();
    }

    public int getCount(int item) {
        return counts[item].get();
    }

    public int getSpan() {
        return counts.length;
    }

    @Override
    public int[] getBuckets() {
        return new int[0];
    }
}

class Histogram4 implements Histogram {
    private AtomicIntegerArray counts;

    public Histogram4(int span) {
        this.counts = new AtomicIntegerArray(span);
    }

    public void increment(int item) {
        counts.getAndIncrement(item);
    }

    public int getCount(int item) {
        return counts.get(item);
    }

    public int getSpan() {
        return counts.length();
    }

    @Override
    public synchronized int[] getBuckets() {
        int[] intArray = new int[counts.length()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = counts.get(i);
        }
        return intArray;
    }
}