package thread.scjp.threads;

public class MyClass extends Thread {//implements Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(new MyClass()) {
            public void run() {
                System.out.println("Dog");
            }
        };
        t.start();
    }

    public void run() {
        System.out.println("Cat");
    }
}
