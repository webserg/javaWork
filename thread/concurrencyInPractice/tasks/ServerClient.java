package thread.concurrencyInPractice.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerClient {
    static int N = 1000;

    public static void main(String[] args) throws UnknownHostException,
            IOException {
        final Count count = new Count();
        Runnable client = new Runnable() {
            @Override
            public void run() {
                ServerClient.clientTask(count.i);
            }
        };
        for (; count.i <= N; count.i++) {
            new Thread(client, "" + count.i).start();
        }
    }

    static void clientTask(int i) {
        Socket theSocket;
        BufferedReader in = null;
        PrintWriter out;
        try {
            theSocket = new Socket("localhost", 8083);
            out = new PrintWriter(theSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(theSocket
                    .getInputStream()));
            String fromServer;
            out.println("hi");
            while ((fromServer = in.readLine()) != null) {
                if (fromServer.equals("privet")) {
                    System.out.println("from server : privet");
                    if (Thread.currentThread().getName().equals("" + N)) {
                        System.out.println("to server : stop!!!!!!!!!!!!");
                        out.println("stop");
                        break;
                    } else {
                        out.println("good by = " + i);
                    }
                } else if (fromServer.equals("by")) {
                    System.out.println("from server : by");
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            in.close();
            out.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Count {
    public int i = 0;
}
