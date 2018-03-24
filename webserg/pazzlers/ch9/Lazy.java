package webserg.pazzlers.ch9;

public class Lazy {

    private static boolean initialized = false;

    static {
        Thread t = new Thread(new Runnable() {
            public void run() {
                initialized = true;
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(initialized);
    }

}
