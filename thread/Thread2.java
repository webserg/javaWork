package thread;

public class Thread2 extends Thread {
    Integer object;

    public Thread2(Integer i) {
        object = i;
        start();
    }

    public void run() {
        while (true) {
            synchronized (object) {

                if (object <= 0) {
                    object.notify();
                    System.out.println(this.toString() + "set " + object--);

                } else {
                    try {
                        object.wait();
                        return;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public String toString() {
        return "second";
    }
}
