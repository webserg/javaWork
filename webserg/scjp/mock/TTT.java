package webserg.scjp.mock;


public class TTT {
    public static void main(String[] args) {
        // Scanner
        StringBuffer b = new StringBuffer("a");
        StringBuffer b1 = new StringBuffer("a");
        System.out.println(b1.equals(b));
        // Arrays
        System.out.format("%.1f", 3.97);
        // NumberFormat
        // Queue<E>
        TH t = new TH("");
        t.start();
        int instanceOf = 1;

    }
}

class TH extends Thread {
    TH(String name) {

    }

    public void run() {
        System.out.println("run");
    }
}