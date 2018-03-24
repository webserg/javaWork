package thread;

public class Waiter {
    Integer y = 1000;
    Foo foo = new Foo();

    /**
     * @param args
     */
    public static void main(String[] args) {
        Waiter ww = new Waiter();
        Waiter.Worker w = ww.new Worker();
        Waiter.User u = ww.new User();
        w.user = u;
        new Thread(u).start();

        new Thread(w).start();


        System.out.println(ww.y);

    }

    class Worker implements Runnable {
        User user;

        public void run() {
            synchronized (foo) {
                while (foo.i < 1000) {
                    try {
                        foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                y -= foo.i;
            }
            System.out.println(y);
        }
    }

    class User implements Runnable {
        //Moo foo = new Moo();

        public void run() {
            synchronized (foo) {
                if (foo.i < 1000) {
                    for (int k = 0; k < 1000; k++) {
                        foo.i++;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    foo.notify();
                }
            }
        }

    }

}

class Foo {
    int i = 0;
}
