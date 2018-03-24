package thread.scjp.threads;

public class Thread2 implements Runnable {
    public static void main(String[] args) {
        Thread t = new Thread(new Thread2());
        t.start();
        System.out.println("End of method");
    }

    public void run() {
        System.out.println("Run: ");
        throw new RuntimeException("Problem");
    }
}

/*
 * which to can be results(choose two)?
 *
 * A: java.lang.RuntimeException: Problem
 * B: run: java.lang.RuntimeException: problem
 * c: End of method java.lanJg.RuntimeException: problem
 * D: End of method  run: java.lang.RuntimeException: problem
 * E: run: java.lang.RuntimeException: problem End of method
 */