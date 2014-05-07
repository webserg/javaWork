package thread.concurrencyInPractice.tasks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class LifeCycleWebserver {
    private static final int NTHREADS = 100;
    private final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(8083);
        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                exec.execute(new Runnable() {
                    public void run() {
                        handleRequest(conn);
                        System.out.println("stop run");
                    }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown())
                    System.out.println("task submission rejected"
                            + e.getMessage());

            }
        }
    }

    /**
     * Initiates an orderly shutdown in which previously
     * submitted tasks are executed, but no new tasks will
     * be accepted. Invocation has no additional effect if
     * already shut down.
     */
    public void stop() {
        System.out.println("shutdown");
        exec.shutdown();
    }

    void handleRequest(Socket connection) {
        try {
            if (Strategy.handleRequest(connection)) {
                System.out.println("stop-----------------------");
                stop();
            }
            // else
            // dispatchRequest(req);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException,
            InterruptedException {
        LifeCycleWebserver server = new LifeCycleWebserver();
        server.start();
        // Thread.sleep(10000);
        // server.stop();

    }

}
