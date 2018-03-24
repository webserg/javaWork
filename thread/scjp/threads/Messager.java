package thread.scjp.threads;

public class Messager implements Runnable {

    private String name;

    public Messager(String name) {
        this.name = name;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Thread(new Messager("Wallace")).start();
        new Thread(new Messager("Gromit")).start();
    }

    public void run() {
        message(1);
        message(2);
    }

    private synchronized void message(int n) {
        System.out.print(name + " - " + n + " ");
    }
}
