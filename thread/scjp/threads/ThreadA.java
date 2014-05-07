package thread.scjp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadA {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        Foo foo = new Foo();
        ThreadB b = new ThreadB();
        b.foo = foo;
        exec.execute(b);
        //b.start();
        synchronized (foo) {
            System.out.println(Thread.currentThread().getName()
                    + " waiting... ");
            Thread.sleep(1);
            while (foo.i < 4950) {
                System.out.println("check results : " + foo.i);
                try {
                    foo.wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("total is " + foo.i);
        }
        /*
           * b.total+=50; System.out.println("another is " + b.total);
           */
        exec.shutdown();
    }


}

class ThreadB extends Thread {
    Foo foo;

    void work() {
        while (foo.i < 4950) {
            synchronized (foo) {

                foo.notifyAll();
                for (int i = 0; i < 50; i++) {
                    foo.i += i;
                    if (i == 25)
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    System.out.println(Thread.currentThread().getName() + " " + i + " " + foo.i);
                }
                System.out.println(foo.i);

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {e.printStackTrace(); }
        }

    }

    public void run() {
        this.work();
    }
}

class Foo {
    volatile int i = 0;
}