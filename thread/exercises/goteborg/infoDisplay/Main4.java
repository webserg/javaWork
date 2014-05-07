package thread.exercises.goteborg.infoDisplay;

import java.util.Random;


public class Main4 {

    private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addProc(HighLevelDisplay d) throws InterruptedException {
        Random randomGenerator = new Random();
        int i = 0;
        while (true) {
            d.addRow("AAAAAAAAAAAA  " + i++);
            nap(randomGenerator.nextInt(5) * 100);
            d.addRow("BBBBBBBBBBBB  " + i++);
        }
    }

    private static void deleteProc(HighLevelDisplay d) throws InterruptedException {
        Random randomGenerator = new Random();
        nap(500);
        while (true) {
            // Add a sequence of deletions of row 0 with short random naps.
            d.deleteRow(0);
            nap(randomGenerator.nextInt(20) * 100);
        }
    }

    public static void main(String[] args) {
        final HighLevelDisplay d = new JDisplayThreadSafe();

        new Thread() {
            public void run() {
                try {
                    addProc(d);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        new Thread() {
            public void run() {
                try {
                    deleteProc(d);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}