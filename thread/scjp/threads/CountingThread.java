package thread.scjp.threads;

public class CountingThread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i % 10 == 0) {
                        System.out.println("i =" + i);
                    }
                }
            }
        }, "count");
        thread.start();

    }

}
