package thread.scjp.threads;

public class JoinThread {
    /**
     * @param args
     */
    public static void main(String[] args) {
        final Thread q = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 400; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        }, "q");
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 400; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                    if (i == 300) {
                        System.out.println("==============================");
                        try {
                            q.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t");

        t.start();
        q.start();

    }

}
