package thread.concurrencyInPractice.tasks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Tasks are logical units of work, and threads are a
 * mechanism by which tasks can run asynchronously.
 * <p/>
 * Switching from a thread-per-task policy to a pool-based
 * policy has a big effect on application stability: the web
 * server will no longer fail under heavy load.[5] It also
 * degrades more gracefully, since it does not create
 * thousands of threads that compete for limited CPU and
 * memory resources. And using an Executor opens the door to
 * all sorts of additional opportunities for tuning,
 * management, monitoring, logging, error reporting, and
 * other possibilities that would have been far more
 * difficult to add without a task execution framework.
 *
 * @author Sergiy Doroshenko webserg@gmail.com Feb 11, 2009
 *         6:06:13 PM
 */
public class TaskExecutionWebServerWithExit {

    private static final int NTHREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);
    private static AtomicBoolean exit = new AtomicBoolean(false);

    public static void main(String[] args) throws IOException {
        final ServerSocket socket = new ServerSocket(8083);
        try {
            while (!exec.isShutdown() && !socket.isClosed()) {
                final Socket connection = socket.accept();
                Runnable task = new Runnable() {  // need boolean to find out when to stop
                    public void run() {
                        try {
                            exit.compareAndSet(false, Strategy.handleRequest(connection));
                            if (exit.get()) {
                                socket.close();
                                exec.shutdown();
                            } else {
                                System.out.println(exit.get());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };
                exec.submit(task);
            }
            System.out.println("exit");
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                // e.printStackTrace();
            }
        }
    }
}