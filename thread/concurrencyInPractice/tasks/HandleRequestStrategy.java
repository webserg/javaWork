package thread.concurrencyInPractice.tasks;


import java.io.IOException;
import java.net.Socket;

public interface HandleRequestStrategy {

    public boolean handleRequest(Socket connection) throws IOException;

}
