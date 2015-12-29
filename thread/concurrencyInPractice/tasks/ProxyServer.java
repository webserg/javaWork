package thread.concurrencyInPractice.tasks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Tasks are logical units of work, and threads are a
 * mechanism by which tasks can run asynchronously.
 * <p>
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
 * @author Sergiy Doroshenko webserg@gmail.com
 */
public class ProxyServer {

    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        int portNumber = parseCommand(args);
        HandleRequestStrategy strategy = new HandleExitStrategy();
        ServerSocket socket = new ServerSocket(portNumber);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> {
                try {
                    strategy.handleRequest(connection);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            exec.execute(task);
        }
    }

    private static int parseCommand(String[] arg) {
        if (arg.length < 1) {
            printUserMessage();
            throw new IllegalArgumentException();
        }
        try {
            return Integer.valueOf(arg[0]);
        } catch (final NumberFormatException ex) {
            printUserMessage();
            throw new IllegalArgumentException(ex);
        }
    }

    private static void printUserMessage() {
        System.out.println("wrong command line");
    }
}
