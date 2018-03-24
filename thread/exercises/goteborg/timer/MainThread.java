package thread.exercises.goteborg.timer;

import java.util.Observable;
import java.util.Observer;

public class MainThread extends Thread implements Observer {

    private boolean terminate = false;
    private EventType event = EventType.NONE;
    private Ticker ti;

    public MainThread(Ticker aTicker) {
        ti = aTicker;
    }

    public synchronized void run() {
        while (!terminate) {
            while (event == EventType.NONE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            switch (event) {
                case NONE: // Should not be possible
                    break;
                case TICK:
                    System.out.println("tick");
                    break;
                case TIMEOUT:
                    terminate = true;
            }
            event = EventType.NONE;
            notifyAll();
        }
        System.out.println("MainThread terminates");
    }

    public synchronized void update(Observable o, Object arg) {
        if (arg instanceof EventType) {
            EventType anEvent = (EventType) arg;
            while (event != EventType.NONE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            event = anEvent;
            notifyAll();
        }
    }
}

