package thread.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by webserg on 27.05.2014.
 * olving the problem above with executors is easy: Divide the array into the number n of available physical processing units,
 * create Callable instances
 * to compute each partial sum, submit them to an executor managing a pool of n threads, and collect the result to compute
 * the final sum.
 * <p>
 * On other types of algorithms and data structures, however, the execution plan often is not so simple. In particular, the “map” phase that
 * identifies chunks of data “small enough” to be processed independently in an efficient manner does not know the data space
 * topology in advance.
 * This is especially true for graph-based and tree-based data structures. In those cases, algorithms should create hierarchies of “divisions,”
 * waiting for subtasks to complete before returning a partial result. Although less optimal in an array like the one in Figure 1,
 * several levels of concurrent partial-sum computations can be used (for example, divide the array into four subtasks on a dual-core processor).
 * <p>
 * The problem with the executors for implementing divide and conquer algorithms is not related to creating subtasks, because a
 * Callable is free to submit a new subtask to its executor and wait for its result in a synchronous or asynchronous fashion. The issue is that of parallelism: When a Callable waits for the result of another Callable, it is put in a waiting state, thus wasting an opportunity to handle another Callable queued for execution.
 */
public class SumsUsingExecutor implements Callable<Long> {
    private int from;
    private int to;

    public SumsUsingExecutor(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        long res = 0;
        for (int i = from; i <= to; i++) {
            res = +i;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Long>> results = executorService.invokeAll(
                Arrays.asList(
                        new SumsUsingExecutor(0, 1_000), new SumsUsingExecutor(1_000, 10_000), new SumsUsingExecutor(10_000, 1_000_000)
                )
        );
        executorService.shutdown();

        for (Future<Long> result : results) {
            System.out.println(result.get());//// we blocks here, so how to avoid it, use continuation CompletableFuture java 8
        }
    }
}
