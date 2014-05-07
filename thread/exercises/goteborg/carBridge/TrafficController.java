package thread.exercises.goteborg.carBridge;

public class TrafficController implements TrafficControllerI {
    private final Object object = new Object();
    private volatile boolean flag = true;
    private final int starvationLimit = 3;
    private volatile int starvationCounterLeft = 0;
    private volatile int starvationCounterRight = 0;

    @Override
    public void enterLeft() {
        try {
            starvationCounterLeft++;
            synchronized (object) {
                while (!flag) {
                    if(starvationCounterRight > 0) object.notify();
                    object.wait(500);
                }
                flag = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterRight() {
        try {
            starvationCounterRight++;
            synchronized (object) {
                while (!flag) {
                    if(starvationCounterLeft > 0) object.notify();
                    object.wait(500);
                }
                flag = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leaveLeft() {
        synchronized (object) {
            flag = true;
            starvationCounterLeft--;
            object.notify();
        }
    }

    @Override
    public synchronized void leaveRight() {
        synchronized (object) {
            flag = true;
            starvationCounterRight--;
            object.notify();
        }
    }

}