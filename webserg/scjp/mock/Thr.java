package webserg.scjp.mock;

public class Thr extends Thread {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Thr().start();
    }

    public void run() {
        System.out.println("a");
//        yield();
        System.out.println("b");
    }

}
