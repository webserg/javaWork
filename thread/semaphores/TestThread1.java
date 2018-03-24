package thread.semaphores;

import java.util.concurrent.Semaphore;

/**
 * User: serg
 * Date: Nov 17, 2008
 * Time: 11:28:54 PM
 */
public class TestThread1 {
    private static final int DELAY = 100;
    private static TestThread1 testthrd;
    private static Thread t1;
    private static Thread t2;
    private static Semaphore sm = new Semaphore(1);

    public static void main(String[] args) throws Exception {
        testthrd = new TestThread1();
        testthrd.startThreads();
        char inkey = '*';
        while (inkey != '.') {
            inkey = (char) System.in.read();
        }
        sm.acquire();
        // t1.interrupt();
        // t2.interrupt();

    }

    public void startThreads() {
        t1 = new Thread(new Work1());
        t2 = new Thread(new Work2());
        t1.start();
        t2.start();
    }

    class Work1 implements Runnable {
        public void run() {
            char t = '0';
            while (true) {
                if (t == '0')
                    try {

                        sm.acquire();
                    } catch (Exception ex) {
                        break;
                    }
                System.out.print(t);
                if (++t > '9') {
                    sm.release();
                    t = '0';
                }
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                }
            } // of while
        }
    }

    class Work2 implements Runnable {
        public void run() {
            char t = 'a';
            while (true) {
                if (t == 'a')
                    try {
                        sm.acquire();
                    } catch (Exception ex) {
                        break;
                    }
                System.out.print(t);
                if (++t > 'z') {
                    sm.release();
                    t = 'a';
                }
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                }
            } // of while
        }
    }
}
