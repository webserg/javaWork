package thread.concurrencyInPractice.tasks;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by webserg on 12/28/2015.
 */
public class ProxyProtocolStrategy implements HandleRequestStrategy {

    @Override
    public boolean handleRequest(Socket connection) throws IOException {
        return false;
    }
}
