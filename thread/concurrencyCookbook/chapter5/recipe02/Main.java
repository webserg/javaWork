package thread.concurrencyCookbook.chapter5.recipe02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Main class of the example.
 * <p>
 * The ForkJoinPool class is an executor class and executes ForkJoinTask instance(s). The main principle of ForkJoinPool
 * is "work stealing", where the threads attempt to find and execute subtasks,
 * which are created by other tasks whose state is still active.  A ForkJoinTask instance is very light weight when
 * compared to a normal Java thread.
 * <p>
 * Once a ForkJoinTask is started, it starts subtasks and then waits for the subtask to finish its execution.
 * The executor ForkJoinPool class is responsible for assigning this subtask to another thread within the Thread Pool,
 * which is currently waiting for some task to be completed. The active threads in the thread pool try to execute some
 * other subtask created by other tasks. Based on the number of processors available, the ForkJoinPool tries to work
 * with that level of parallelism by maintaining adequate active threads at any given point of time.
 * <p>
 * ForkJoinTask has two main methods, apart from several other API methods, which are:
 * <p>
 * fork () – This method decides on asynchronous execution of the ForkJoinTask. By virtue of this method,
 * a new task can be created.
 * join () – This method is responsible for returning the results once the computation is completed.
 * This allows a task to wait for the completion of another task.
 */
public class Main {

    /**
     * Main method of the class
     */
    public static void main(String[] args) {

        // Generate a document with 100 lines and 1000 words per line
        DocumentMock mock = new DocumentMock();
        String[][] document = mock.generateDocument(100, 1000, "the");

        // Create a DocumentTask
        DocumentTask task = new DocumentTask(document, 0, 100, "the");

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Execute the Task
        pool.execute(task);

        // Write statistics about the pool
        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (!task.isDone());

        // Shutdown the pool
        pool.shutdown();

        // Wait for the finalization of the tasks
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Write the results of the tasks
        try {
            System.out.printf("Main: The word appears %d in the document", task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
