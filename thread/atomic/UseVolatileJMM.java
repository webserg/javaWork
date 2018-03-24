package thread.atomic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseVolatileJMM {
    static Map<String, String> configOptions = new TreeMap<>();
    static char[] configText;
    static int j = 0;
    private static boolean initialized = false;
    private static int k = 0;

    public static void methodA() {
        // configOptions = new TreeMap<>();
        configOptions.put("1", "1");
        configOptions.put("2", "1");
        configOptions.put("3", "1");
        configOptions.put("4", "1");
        File file = new File("file.txt");
        File file2 = new File(".");
        System.out.println(file2.getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int i = 5;
            while (true) {
                String s = br.readLine();
                if (s == null) break;
                configOptions.put((i++) + "", s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        configText = "hello world".toCharArray();
        k++;
        initialized = true;
    }

    public static void methodB() {
        try {
            System.out.println("start = " + j++);
            while (!initialized)
                Thread.sleep(1);
            System.out.println("===========" + k);

            System.out.println("size=" + configOptions.size() + " {" + configOptions.toString() + "}");
            System.out.println(configText);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //final UseVolatileJMM obj = new UseVolatileJMM();
        Runnable a = new Runnable() {
            @Override
            public void run() {
                methodA();
            }
        };
        Runnable b = new Runnable() {
            @Override
            public void run() {
                methodB();
            }
        };
        ExecutorService ex = Executors.newFixedThreadPool(5);
        ex.execute(b);
        ex.execute(b);
        ex.execute(b);
        ex.execute(a);
        ex.execute(b);
        ex.shutdown();
        //new Thread(b).start();
        //new Thread(b).start();
        //new Thread(a).start();
        //new Thread(b).start();
    }

}
