package thread.concurrencyInPractice.schedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Problem with Timer is that it behaves poorly if a
 * TimerTask throws an unchecked exception. The Timer thread
 * doesn't catch the exception, so an unchecked exception
 * thrown from a TimerTask terminates the timer thread.
 *
 * @author Sergiy Doroshenko webserg@gmail.com Feb 13, 2009
 * 6:16:19 PM
 */
public class OutOfTime {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        Thread.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        Thread.sleep(5);
    }

    static class ThrowTask extends TimerTask {
        public void run() {
            throw new RuntimeException();
        }
    }
}
