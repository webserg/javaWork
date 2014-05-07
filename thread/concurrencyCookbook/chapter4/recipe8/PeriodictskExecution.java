package thread.concurrencyCookbook.chapter4.recipe8;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * PeriodictskExecution class of the example. Send a task to the executor that will execute every
 * two seconds. Then, control the remaining time for the next execution of the task
 * <p>
 * When you want to execute a periodic task using the Executor framework, you need
 * a ScheduledExecutorService object. To create it (as with every executor), Java
 * recommends the use of the Executors class. This class works as a factory of executor
 * objects. In this case, you should use the newScheduledThreadPool() method to create a
 * ScheduledExecutorService object. That method receives as a parameter the number of
 * threads of the pool. As you have only one task in this example, you have passed the value 1 as
 * a parameter
 */
public class PeriodictskExecution {

    /**
     * PeriodictskExecution method of the class
     *
     * @param args
     */
    public static void main(String[] args) {

        // Create a ScheduledThreadPoolExecutor
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.printf("PeriodictskExecution: Starting at: %s\n", new Date());

        // Create a new task and sends it to the executor. It will start with a delay of 1 second and then
        // it will execute every two seconds
        Task task = new Task("Task");
        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // Controlling the execution of tasks
        for (int i = 0; i < 10; i++) {
            System.out.printf("PeriodictskExecution: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Finish the executor
        executor.shutdown();
        System.out.printf("PeriodictskExecution: No more tasks at: %s\n", new Date());
        // Verify that the periodic tasks no is in execution after the executor shutdown()
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // The example finish
        System.out.printf("PeriodictskExecution: Finished at: %s\n", new Date());

    }

}
