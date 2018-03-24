package thread.scjp.threads;

public class StaticSynch2 {
    Thread t = new Thread();

    public static synchronized void main(String[] args) throws InterruptedException {
        StaticSynch2 staticSynch2 = new StaticSynch2();
        staticSynch2.t.start();
        System.out.print("X");
        new StaticSynch2().go();
        System.out.print("Y");
    }

    /**
     * @param args
     */
    void go() throws InterruptedException {
        synchronized (t) {
            t.wait(10000);
        }
    }
}
