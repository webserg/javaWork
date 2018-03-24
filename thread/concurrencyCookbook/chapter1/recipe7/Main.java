package thread.concurrencyCookbook.chapter1.recipe7;

import java.util.concurrent.TimeUnit;

/**
 * PeriodictskExecution class of the UnsafeTask. Creates a Runnable task and
 * three Thread objects that run it.
 */
public class Main {

    /**
     * PeriodictskExecution method of the UnsafeTaks. Creates a Runnable task and
     * three Thread objects that run it.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Creates the unsafe task
        UnsafeTask task = new UnsafeTask();

        // Throw three Thread objects
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
