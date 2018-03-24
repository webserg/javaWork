package thread.scjp.threads;

public class NameRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 100 && "a".equals(Thread.currentThread().getName())) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
