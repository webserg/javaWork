package algoritms.piped;

import java.io.PipedReader;

public class Reader extends Thread {
    private PipedReader in;

    public Reader(Sender sender) throws Exception {
        in = new PipedReader(sender.getPipedWriter());
    }

    public void run() {
        try {
            while (true) {
                System.out.println((char) in.read());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
