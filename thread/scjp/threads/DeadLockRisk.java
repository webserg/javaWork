package thread.scjp.threads;

public class DeadLockRisk {
    private Resource reasourseA = new Resource();
    private Resource reasourseB = new Resource();

    /**
     * @param args
     */
    public static void main(String[] args) {
        final DeadLockRisk r = new DeadLockRisk();
        Thread t = new Thread() {
            public void run() {
                for (int i = 0; i < 1000000000; i++) {
                    r.write(1, 1);
                }
                System.out.println(Thread.currentThread().getName() + " " + r.read());
            }
        };
        new Thread(t, "1") {
        }.start();
        new Thread(t, "2") {
        }.start();


    }

    public int read() {
        synchronized (reasourseA) {
            synchronized (reasourseB) {
                return reasourseA.i + reasourseB.i;
            }
        }
    }

    public void write(int a, int b) {
        synchronized (reasourseB) {
            synchronized (reasourseA) {
                reasourseA.i += a;
                reasourseB.i += b;
            }
        }
    }

    private static class Resource {
        public int i;
    }

}
