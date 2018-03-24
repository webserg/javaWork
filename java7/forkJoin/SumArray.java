package java7.forkJoin;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by webserg on 21.05.2014.
 */
public class SumArray extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10;
    private final Integer[] array;
    private final int low;
    private final int high;

    public SumArray(Integer[] array, int low, int high) {
        super();
        this.array = array;
        this.low = low;
        this.high = high;
    }

    public static void main(String[] args) throws Exception {
        Integer[] anArray = new Integer[Integer.MAX_VALUE / 50];
        Random r = new Random();
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = r.nextInt(10);
        }
        RecursiveTask<Integer> task = new SumArray(anArray, 0, anArray.length);
        ForkJoinPool mainPool = new ForkJoinPool();
        Future<Integer> future = mainPool.submit(task);
        System.out.println(mainPool.getActiveThreadCount());
        System.out.println(mainPool.getStealCount());
        System.out.println(future.get());
    }

    @Override
    protected Integer compute() {
        int res = 0;
        if (high - low <= THRESHOLD) {
            for (int i = low; i < high; i++) {
                res += array[i];
            }
        } else {
            int mid = (low + high) >>> 1;
            RecursiveTask<Integer> t1 = new SumArray(array, low, mid);
            RecursiveTask<Integer> t2 = new SumArray(array, mid, high);
            invokeAll(t1, t2);
            try {
                res = t1.get() + t2.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
