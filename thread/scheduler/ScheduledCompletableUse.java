package thread.scheduler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * https://www.artificialworlds.net/blog/2019/04/05/scheduling-a-task-in-java-within-a-completablefuture/
 * Future returned from schedule() is a ScheduledFuture, and a ScheduledFuture is not a CompletableFuture.
 * <p>
 * Why do you care? Well, you might care if you want to do something after the scheduled task is completed. Of course, you can call get(),
 * and block, and then do something, but if you want to react asynchronously without blocking, this won’t work.
 * <p>
 * The normal way to run some code after a Future has completed is to call one of the “then*” or “when*” methods on the Future, but these
 * methods are only available on CompletableFuture, not ScheduledFuture.
 * <p>
 * Never fear, we have figured this out for you. We present a small wrapper for schedule that transforms your ScheduledFuture
 * into a CompletableFuture. Here’s how to use it:
 */
public class ScheduledCompletableUse {
    public static void main(String[] args) throws Exception {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        executor.scheduleWithFixedDelay(
                () -> {
                    System.out.println("..later");
                },
                1,
                1,
                TimeUnit.SECONDS
        );
        System.out.println("do...");
// (Don't forget to shut down the executor later...)

        Supplier<CompletableFuture<Integer>> asyncTask = () ->
                CompletableFuture.completedFuture(10 + 25);
        CompletableFuture<Integer> future =
                scheduleAsync(
                        executor, asyncTask, 1, TimeUnit.SECONDS);
        future.thenAccept(
                answer -> {
                    System.out.println(answer);
                }
        );
        System.out.println("Answer coming...");

        var b = executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    public static <T> CompletableFuture<T> schedule(
            ScheduledExecutorService executor,
            Supplier<T> command,
            long delay,
            TimeUnit unit
    ) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        executor.schedule(
                (() -> {
                    try {
                        return completableFuture.complete(command.get());
                    } catch (Throwable t) {
                        return completableFuture.completeExceptionally(t);
                    }
                }),
                delay,
                unit
        );
        return completableFuture;
    }

    public static <T> CompletableFuture<T> scheduleAsync(
            ScheduledExecutorService executor,
            Supplier<CompletableFuture<T>> command,
            long delay,
            TimeUnit unit
    ) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        executor.schedule(
                (() -> {
                    command.get().thenAccept(
                                    t -> {
                                        completableFuture.complete(t);
                                    }
                            )
                            .exceptionally(
                                    t -> {
                                        completableFuture.completeExceptionally(t);
                                        return null;
                                    }
                            );
                }),
                delay,
                unit
        );
        return completableFuture;
    }
}
