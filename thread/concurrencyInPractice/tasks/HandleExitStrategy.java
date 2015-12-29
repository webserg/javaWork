package thread.concurrencyInPractice.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HandleExitStrategy implements HandleRequestStrategy {
    /**
     * @param connection
     * @return boolean isShoutdown
     * @throws IOException
     */
    @Override
    public boolean handleRequest(Socket connection) throws IOException {
        boolean isShoutdown = false;

        String inLine;
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(connection
                        .getInputStream()));
                PrintWriter out = new PrintWriter(connection.getOutputStream(), true)
        ) {
            while ((inLine = in.readLine()) != null) {
                if (inLine.equals("hi")) {
                    System.out.println("from client : hi");
                    out.println("privet");
                    out.flush();
                } else if (inLine.startsWith("good by")) {
                    System.out.println("from client: " + inLine);
                    out.println("by");
                    out.flush();
                } else if (inLine.equals("stop")) {
                    System.out.println("from client: stop!!!!!!!!!!!!!!!!1");
                    out.flush();
                    return true;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return isShoutdown;
    }
}
