package thread.restaurant;

public class Chef extends Thread {
    WaitPerson1 waitPerson;

    // Order order;
    Restaurant restaurant;

    Chef(WaitPerson1 w, Restaurant r) {
        waitPerson = w;
        restaurant = r;
        start();
    }

    public void run() {
        while (true) {
            if (null == waitPerson.r.order) {
                waitPerson.r.order = new Order();
            }
            synchronized (waitPerson) {
                System.out.println("wake up");
                waitPerson.notifyAll();

            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
