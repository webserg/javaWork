package ThreadLocal;

public class SerialNum {
    // The next serial number to be assigned
    private static int nextSerialNum = 0;
    private static ThreadLocal serialNum = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new Integer(nextSerialNum++);
        }
    };
    Integer c = new Integer(0);
    int q = 200;

    public static int get() {
        return ((Integer) (serialNum.get())).intValue();
    }

    public static void main(String[] argv) {
        final SerialNum serialNum = new SerialNum();
        Thread stopper = new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.exit(0);
            }
        };
        Thread r = new Thread() {
            public void run() {
                while (serialNum.q > 0) {
                    synchronized (serialNum.c) {
                        if (serialNum.c == 0) {
                            System.out.println(Thread.currentThread().getName()
                                    + " " + get());
                            serialNum.c++;
                        }
                    }
                    serialNum.q++;

                }
            }
        };
        Thread r2 = new Thread() {
            public void run() {
                while (serialNum.q > 0) {
                    synchronized (serialNum.c) {
                        if (serialNum.c == 1) {
                            System.out.println(Thread.currentThread().getName()
                                    + " " + get());
                            serialNum.c--;
                        }
                    }
                }
                serialNum.q--;

            }
        };
        stopper.start();
        r.start();
        r2.start();
    }
}
