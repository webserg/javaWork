package thread.ItUniversityCopenhagen.ex3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by webserg on 12/28/2015.
 */
public class HistogramTest {
    private static final int NTHREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws InterruptedException {
        final Histogram histogram = new Histogram1(30);
        Runnable task = () -> {

            histogram.increment(7);
            histogram.increment(13);
            histogram.increment(7);

        };
        for (int i = 0; i < NTHREADS * NTHREADS; i++) {
            exec.submit(task);
        }
        exec.awaitTermination(10, TimeUnit.SECONDS);
        dump(histogram);
    }

    public static void dump(Histogram histogram) {
        int totalCount = 0;
        for (int item = 0; item < histogram.getSpan(); item++) {
            System.out.printf("%4d: %9d%n", item, histogram.getCount(item));
            totalCount += histogram.getCount(item);
        }
        System.out.printf("      %9d%n", totalCount);
    }
}
