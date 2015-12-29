package thread.concurrencyInPractice.tasks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A more responsive approach is to create a new thread for
 * servicing each request
 * <p>
 * The problem with the thread-per-task approach is that
 * nothing places any limit on the number of threads created
 * except the rate at which remote users can throw HTTP
 * requests at it.So a malicious user, or enough ordinary
 * users, can make your web server crash if the traffic load
 * ever reaches a certain threshold.
 *
 * @author Sergiy Doroshenko webserg@gmail.com Feb 11, 2009
 *         1:31:53 PM
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        HandleRequestStrategy strategy = new HandleExitStrategy();
        ServerSocket socket = new ServerSocket(8083);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> {
                try {
                    strategy.handleRequest(connection);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            new Thread(task).start();
        }
    }
}
