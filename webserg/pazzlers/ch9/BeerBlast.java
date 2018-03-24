package webserg.pazzlers.ch9;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sergiy Doroshenko
 */
public class BeerBlast {
    static final String COMMAND = "java BeerBlast slave";

    static void drainInBackground(final InputStream is) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    int c;
                    while ((c = is.read()) >= 0) {
                        System.out.print((char) c);
                    }
                } catch (IOException e) {
                    // TODO: handle exception
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 1 && args[0].equals("slave")) {
            for (int i = 10; i > 0; i--) {
                System.out.println(i + " bottles of beer on the wall");
                System.out.println(i + " bottles of beer");
                System.out.println("You take one down, pass it around,");
                System.out.println((i - 1) + " bottles of beer on the wall");
                System.out.println();
            }
        } else {
            // Master
			/*Process process = Runtime.getRuntime().exec(COMMAND);
			drainInBackground(process.getInputStream());
			int exitValue = process.waitFor();
			System.out.println("exit value = " + exitValue);*/
            File dir = new File("C:\\devel\\workingSnap\\classes");
            System.out.println(dir.isDirectory());
            ProcessBuilder processBuilder = new ProcessBuilder("java", "webserg.pazzlers.ch9.BeerBlast", "slave");

            processBuilder.redirectErrorStream(true);
            processBuilder.directory(dir);
            System.out.println(processBuilder.directory());
            System.out.println(processBuilder.redirectErrorStream());

            Process process = processBuilder.start();
            drainInBackground(process.getInputStream());
            int exitValue = process.waitFor();
            System.out.println("exit value = " + exitValue);

        }
    }
}
