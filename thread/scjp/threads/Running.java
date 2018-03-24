package thread.scjp.threads;

public class Running implements Runnable {


    /**
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new Thread(new Running());
        t.run();
        t.run();
        t.start();
    }

    public void run() {
        System.out.print("running");

    }

}
