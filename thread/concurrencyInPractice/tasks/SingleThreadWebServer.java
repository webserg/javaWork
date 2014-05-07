package thread.concurrencyInPractice.tasks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SingleThreadedWebServer is simple and theoretically
 * correct, but would perform poorly in production because
 * it can handle only one request at a time. The main thread
 * alternates between accepting connections and processing
 * the associated request. While the server is handling a
 * request, new connections must wait until it finishes the
 * current request and calls accept again.
 * 
 * @author Sergiy Doroshenko webserg@gmail.com Feb 11, 2009
 *         1:19:27 PM
 */
public class SingleThreadWebServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(8083);

            while (true) {
                Socket connection = socket.accept();
                Strategy.handleRequest(connection);
            }
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.exit(0);
        }

    }
}
