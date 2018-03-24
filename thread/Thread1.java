package thread;

public class Thread1 extends Thread {
    static Integer object;

    public Thread1(Integer i, String name) {
        super(name);
        object = i;
        start();
    }

    public void run() {
        while (true) {
            //	synchronized (object) {
            if (this.getName().equals("first")) {
                if (object <= 100) {
                    //object.notify();
                    System.out.println(this.toString() + "set " + object++);
                } else {
                    try {
                        this.wait();
                        //return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (this.getName().equals("second")) {
                if (object >= 0) {
                    //object.notify();
                    System.out.println(this.toString() + "set " + object--);
                } else {
                    try {
                        this.wait();
                        //return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        //}
    }

    public String toString() {
        return getName();
    }
}
