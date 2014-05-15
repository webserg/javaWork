package thread.exercises.goteborg.timer;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread5 extends Thread implements Observer {

    private volatile boolean terminate = false;
    private BlockingQueue<EventType> queue = new LinkedBlockingQueue<EventType>();
    private Ticker ti;

    public MainThread5(Ticker aTicker) {
        ti = aTicker;
    }

    public void run() {
        EventType event;

        while (!terminate) {
            event = null;
            while (event == null) {
                try {
                    event = queue.take();
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
                    System.out.println("timeout");
                    terminate = true;
                    break;
            }
        }
        System.out.println("MainThread terminates");
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof EventType) {
            EventType anEvent = (EventType) arg;
            try {
                queue.put(anEvent);
            } catch (InterruptedException e) {
                // This will not happen as we use an unbounded queue.
            }
        }
    }
}

