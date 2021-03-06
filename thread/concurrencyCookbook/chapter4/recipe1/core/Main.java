package thread.concurrencyCookbook.chapter4.recipe1.core;

/**
 * PeriodictskExecution class of the example. Creates a server and 100 request of the Task class
 * that sends to the server
 */
public class Main {

    /**
     * PeriodictskExecution method of the example
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create the server
        Server server = new Server();

        // Send 100 request to the server and finish
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }

        server.endServer();

    }

}
