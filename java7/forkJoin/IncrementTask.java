package java7.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by webserg on 25.04.2014.
 */
public class IncrementTask extends RecursiveAction {
    private static final int THRESHOLD = 5000;
    private final int[] array;
    private final int low;
    private final int high;
    private final int tasksCount = 0;

    public IncrementTask(int[] array, int low, int high) {
        super();

        this.array = array;
        this.low = low;
        this.high = high;
    }

    public static void main(String[] args) {
        int[] anArray = new int[Integer.MAX_VALUE / 10];
        assert anArray[Integer.MAX_VALUE / 10] == 0;
        RecursiveAction mainTask = new IncrementTask(anArray, 0, anArray.length);
        ForkJoinPool mainPool = new ForkJoinPool();
        mainPool.invoke(mainTask);
        assert anArray[Integer.MAX_VALUE / 10] == 1;
        System.out.println(mainPool.getActiveThreadCount());
        System.out.println(mainPool.getStealCount());
    }

    @Override
    protected void compute() {
        if (high - low < THRESHOLD) {
            for (int i = low; i < high; ++i) {
                array[i]++;
            }
        } else {
            int mid = (low + high) >>> 1;

            invokeAll(new IncrementTask(array, low, mid), new IncrementTask(array, mid, high));
        }
    }
}

