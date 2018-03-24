package thread.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by webserg on 28.05.2014.
 */
public class SumsUsingComplFuture implements Callable<Long> {
    private int from;
    private int to;

    public SumsUsingComplFuture(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Long>> results = executorService.invokeAll(
                Arrays.asList(
                        new SumsUsingComplFuture(0, 1_000), new SumsUsingComplFuture(1_000, 10_000), new SumsUsingComplFuture(10_000, 1_000_000)
                )
        );
        executorService.shutdown();

        for (Future<Long> result : results) {
            System.out.println(result.get());// we blocks here, so how
        }
    }

    @Override
    public Long call() throws Exception {
        long res = 0;
        for (int i = from; i <= to; i++) {
            res = +i;
        }
        return res;
    }
}
