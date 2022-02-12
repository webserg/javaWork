package thread.scheduler;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
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

    AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {
//        useGuava();
        ChainOfTasks chainOfTasks = new ChainOfTasks();
        chainOfTasks.useScheduledExecutor();
    }


    /**
     * use java library
     */
    private void useScheduledExecutor() {
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

    private Boolean task(int i) {
        makeActualJob(i);

        CompletableFuture
                .supplyAsync(new FirstTask(new FlowData(integer.incrementAndGet())))
                .thenApplyAsync(new SecondTask())
                .thenAcceptAsync(new TaskAfterFinal())
                .exceptionally(new ExceptionTask());

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


    static class FlowData {
        public int id;
        public boolean isSuccess = true;

        public FlowData(int i) {
            this.id = i;
        }

        @Override
        public String toString() {
            return "FlowData{" +
                    "id=" + id +
                    ", isSuccess=" + isSuccess +
                    '}';
        }
    }

    static class FirstTask implements Supplier<FlowData> {
        private final FlowData flowData;

        public FirstTask(FlowData flowData) {
            this.flowData = flowData;
        }

        @Override
        public FlowData get() {

            try {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                int d = 1/0;
                System.out.println("finish async first task# " + flowData.id);
//                var res =  (Boolean) f.get();
//                System.out.println("res" + i );
                return flowData;

            } catch (Throwable e) {
                e.printStackTrace();
            }
            flowData.isSuccess = false;
            return flowData;
        }
    }

    static class SecondTask implements Function<FlowData, FlowData> {

        public SecondTask() {
        }

        @Override
        public FlowData apply(FlowData flowData) {

            if (!flowData.isSuccess) return flowData;

            try {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                int d = 1/0;
                System.out.println("finish async second task#" + flowData);
//                var res =  (Boolean) f.get();
//                System.out.println("res" + i );
                return flowData;

            } catch (Throwable e) {
                e.printStackTrace();
            }
            flowData.isSuccess = false;
            return flowData;
        }

    }
    static class TaskAfterFinal implements Consumer<FlowData> {

        @Override
        public void accept(FlowData o) {
            System.out.println("finish async final task# " + o.id + " finish ");
            if (!o.isSuccess) throw new RuntimeException();
        }

    }

    static class ExceptionTask implements Function<Throwable, Void> {

        public ExceptionTask() {
        }

        @Override
        public Void apply(Throwable throwable) {
            System.out.println("Throwable ExceptionTask false " + throwable.getMessage());
            return null;
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
