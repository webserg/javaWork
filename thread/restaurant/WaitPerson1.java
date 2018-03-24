package thread.restaurant;

public class WaitPerson1 extends Thread implements Person {
    public int n;
    Restaurant r;

    public WaitPerson1(Restaurant restaurant, int number) {
        r = restaurant;
        n = number;
        start();
    }

    public void run() {
        while (true) {
            if (null == r.order) {
                System.out.println("made order");
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (null != r.order) {
                System.out.println("order was accepted");
                r.order = null;
            }

        }
    }
}
