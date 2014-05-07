package thread.restaurant;

public class WaitPerson2 extends Thread implements Person {
    Restaurant r;

    public WaitPerson2(Restaurant restaurant) {
        r = restaurant;
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
