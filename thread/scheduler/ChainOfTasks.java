package thread.scheduler;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * how to write chain of tasks with callbacks
 * schedule task then check result and sent result to another destination plus check sending for exception
 * <p>
 * download trade, process it, send status of processing to monitor system, check sending status for exception
 */
public class ChainOfTasks {

    public static void main(String[] args) {
//        useGuava();
        useScheduledExecutor();
    }



    /**
     * use java library
     */
    private static void useScheduledExecutor() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        for (int i = 1; i <= 2; i++) {
            final int k = i;
            ScheduledFuture<?> f = executor.scheduleWithFixedDelay(() -> task(k), 1 + k, 2 + k, TimeUnit.SECONDS);

        }
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    private static Boolean task(int i) {
        makeActualJob(i);
        CompletableFuture.supplyAsync(new CompleteTask(i)).thenAccept(new FinalTask(i)).exceptionally(new ExceptionTask(i));
        System.out.println("finish " + i);
        return true;
    }

    private static void makeActualJob(int i) {
        System.out.println("run" + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    static class Task implements Runnable {
//        private int i;
//
//        public Task(int i) {
//            this.i = i;
//        }
//
//        @Override
//        public Boolean call() throws Exception {
//
//
//            System.out.println("run " + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (i == 5) throw new Exception("failed " + i);
//            return true;
//        }
//    }

    static class CompleteTask implements Supplier<Boolean> {
        private int i;

        public CompleteTask(int i) {
            this.i = i;
        }

        @Override
        public Boolean get() {

            try {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("finish async" + i);
//                var res =  (Boolean) f.get();
//                System.out.println("res" + i );
                return true;

            } catch (Throwable e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    static class ExceptionTask implements Function<Throwable, Void> {
        private int i;

        public ExceptionTask(int i) {
            this.i = i;
        }

        @Override
        public Void apply(Throwable throwable) {
            System.out.println("false " + i);
            return null;
        }
    }

    static class FinalTask implements Consumer<Boolean> {
        private final int i;

        public FinalTask(int i) {
            this.i = i;
        }

        @Override
        public void accept(Boolean o) {
            System.out.println("task number " + i + " finish " + o);
            if (!o) throw new RuntimeException();
        }
    }

    /**
     * use framework
     */
    private static void useGuava() {
        ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(2));
        for (int i = 0; i < 2; i++) {

            ListenableFuture<String> f = executor.submit(() -> {
                System.out.println("run");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "name";
            });
            Futures.addCallback(f, new FutureCallback<String>() {
                public void onSuccess(String result) {
                    System.out.println("success" + result);
                }

                public void onFailure(Throwable thrown) {
                    System.out.println("failure");
                }
            });
        }

        executor.shutdown();
    }
}
