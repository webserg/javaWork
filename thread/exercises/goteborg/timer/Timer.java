package thread.exercises.goteborg.timer;

import thread.concurrencyCookbook.chapter6.recipe04.Event;

import java.util.*;

public class Timer extends Observable implements Runnable {

    private int ms;
    private Thread t;
 
    public Timer(int aMs) {
	ms = aMs;
	t = new Thread(this);
    }

    public void start() {
	t.start();
    }

    public void run() {
	try {
	    Thread.sleep(ms);
        System.out.println("timeout ms");
        setChanged();
        this.notifyObservers(EventType.TIMEOUT);
	} catch (InterruptedException e) {}
    }

}
	    
