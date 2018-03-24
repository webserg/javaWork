package thread.concurrencyInPractice.threadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author : Sergey Doroshenko
 * email: webserg@gmail.com
 * Date: Dec 14, 2008
 * Time: 10:38:20 PM
 */
public class ThreadPoolExecution {
    final static Counter c = new Counter();
    private final static int N = 5;
    private final static ExecutorService exec = Executors.newFixedThreadPool(N);

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 100; i++) {
            System.out.println(i);
            exec.execute(new TaskFib(c, i, 30));
        }
        exec.shutdown();
    }
}

class Counter {
    public volatile int c = 0;
}
