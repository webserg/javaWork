package thread.concurrencyCookbook.chapter4.recipe12;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * PeriodictskExecution class of the example
 */
public class Main {

    /**
     * PeriodictskExecution method of the example
     *
     * @param args
     */
    public static void main(String[] args) {

        // Create the controller for the Rejected tasks
        RejectedTaskController controller = new RejectedTaskController();
        // Create the executor and establish the controller for the Rejected tasks
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(controller);

        // Lauch three tasks
        System.out.printf("PeriodictskExecution: Starting.\n");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task" + i);
            executor.submit(task);
        }

        // Shutdown the executor
        System.out.printf("PeriodictskExecution: Shuting down the Executor.\n");
        executor.shutdown();

        // Send another task
        System.out.printf("PeriodictskExecution: Sending another Task.\n");
        Task task = new Task("RejectedTask");
        executor.submit(task);

        // The program ends
        System.out.printf("PeriodictskExecution: End.\n");

    }

}
