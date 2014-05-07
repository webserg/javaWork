package thread.exercises.goteborg.infoDisplay;

import java.util.Random;
import java.util.concurrent.Semaphore;


public class MainSemafores {

    private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addProc(HighLevelDisplay d, Semaphore sem) throws InterruptedException {
        Random randomGenerator = new Random();
        int i = 0;
        while (true) {
            sem.acquire();
            d.addRow("AAAAAAAAAAAA  " + i++);
            sem.release();

            nap(randomGenerator.nextInt(5) * 100);
            sem.acquire();
            d.addRow("BBBBBBBBBBBB  " + i++);
            sem.release();
        }
    }

    private static void deleteProc(HighLevelDisplay d, Semaphore sem) throws InterruptedException {
        Random randomGenerator = new Random();
        nap(500);
        while (true) {
            // Add a sequence of deletions of row 0 with short random naps.
            sem.acquire();
            d.deleteRow(0);
            sem.release();
            nap(randomGenerator.nextInt(5) * 100);
        }
    }

    public static void main(String[] args) {
        final HighLevelDisplay d = new JDisplayNotThreadSafe();
        final Semaphore sem = new Semaphore(1);

        new Thread() {
            public void run() {
                try {
                    addProc(d, sem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        new Thread() {
            public void run() {
                try {
                    deleteProc(d, sem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}