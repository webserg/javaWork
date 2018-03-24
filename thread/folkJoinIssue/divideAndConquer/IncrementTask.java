package thread.folkJoinIssue.divideAndConquer;

import java.util.concurrent.RecursiveAction;

/**
 * User: webserg
 * Date: 09.12.11
 * <p/>
 * The most important improvement is a new Fork/Join Framework. Fork/Join is basically the parralel version of the
 * divide-and-conquer algorithm resolution. Here is the typical form of that problems (taken from Doug Lea) :
 * Result solve(Problem problem) {
 * if (problem is small)
 * directly solve problem
 * else {
 * split problem into independent parts
 * fork new subtasks to solve each part
 * join all subtasks
 * compose result from subresults
 * }
 * }
 * Java 7 provide a new class ForkJoinPool to run ForkJoinTask. A ForkJoinTask is lighter than a thread. If you have a
 * lot of ForkJoinTask, you can host them with a smallest number of threads. Two implementations of ForkJoinTask are provided :
 * RecursiveAction : A recursive resultless ForkJoinTask
 * RecursiveTask<E> : A recursive ForkJoinTask that return an object of type E
 */
public class IncrementTask extends RecursiveAction {
    private static final int THRESHOLD = 5000;
    private final long[] array;
    private final int low;
    private final int high;

    public IncrementTask(long[] array, int low, int high) {
        super();

        this.array = array;
        this.low = low;
        this.high = high;
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
