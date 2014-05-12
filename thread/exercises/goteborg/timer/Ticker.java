package thread.exercises.goteborg.timer;

import java.util.*;

public class Ticker extends Observable implements Runnable {

    private int period;
    private Thread t;

    public Ticker(int aPeriod) {
	period = aPeriod;
	t = new Thread(this);
    }

    public void start() {
	t.start();
    }

    public synchronized void run() {
        long next = System.currentTimeMillis() + period;
	while(true) {
	    try {
		wait(Math.max(next - System.currentTimeMillis(),1));
	    } catch (InterruptedException e) {}
	    //
	    // Both setChanged and notifyObservers are needed
	    // to actually notify all the observers.
	    //
	    setChanged();
	    notifyObservers(EventType.TICK);
	    next += period;
	}
    }

}
