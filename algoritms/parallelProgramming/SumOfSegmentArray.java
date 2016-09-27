package algoritms.parallelProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by webserg on 9/23/2016.
 */
public class SumOfSegmentArray {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static int threashold = 10;

    public static void main(String[] args) throws Exception{
        int[] array = new int[100];
        int s = 5;
        int t = 10;
        double p = 2;
        double res = getSumSegment(array, s, t, p);
        System.out.println(res);
        System.out.println(pNorm(array, 2));
        System.out.println(pNormTwoPart(array, 2));
        System.out.println(pNormTwoPartConcurent(array, 2));
        System.out.println(pNormTwoPartParallel(array, 2));
        executorService.shutdown();
    }

    private static double getSumSegment(int[] array, int s, int t, double p) {

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 2;
        }
        double res = 0;
        while (s < t) {
            double powA = Math.pow(array[s], p);
            res += powA;
            s++;
        }
        return res;
    }

    private static double pNorm(int[] array, double p) {
        return Math.pow(getSumSegment(array, 0, array.length, p), 1 / p);
    }

    private static double pNormTwoPart(int[] array, double p) {
        int m = array.length / 2;
        double first = getSumSegment(array, 0, m, p);
        double second = getSumSegment(array, m, array.length, p);
        return Math.pow(first + second, 1 / p);
    }

    private static double pNormTwoPartConcurent(int[] array, double p) throws InterruptedException, ExecutionException {
        final int m = array.length / 2;
        List<Future<Double>> results = executorService.invokeAll(
                Arrays.asList(
                        () -> getSumSegment(array, 0, m, p),
                        () -> getSumSegment(array, m, array.length, p)
                )
        );

        return Math.pow(results.get(0).get() + results.get(1).get(), 1 / p);
    }

    private static double pNormTwoPartParallel(int[] array, double p) throws Exception {
        Double results = segmentRec(array, 0, array.length, p);
        return Math.pow(results, 1 / p);
    }

    private static Double segmentRec(int[] array, int s, int t, double p) throws Exception {
        if (t - s < threashold) {
            return getSumSegment(array, s, t, p);
        }

        final int m = s + (t - s) / 2;

        return parallel(() -> getSumSegment(array, s, m, p), () -> getSumSegment(array, m, t, p));
    }

    private static Double parallel(Callable<Double> c1, Callable<Double> c2) throws Exception {
        List<Future<Double>> futures = executorService.invokeAll(
                Arrays.asList(c1, c2)
        );
        return futures.get(0).get() + futures.get(1).get();
    }
}
