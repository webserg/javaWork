package thread.liveness;

import java.util.Random;

/**
 * Created by sergiy.doroshenko
 * Date: 10/28/11
 * <p>
 * A concurrent application's ability to execute in a timely manner is known as its liveness.
 * This section describes the most common kind of liveness problem, deadlock, and goes on
 * to briefly describe two other liveness problems, starvation and livelock.
 * <p>
 * Starvation and livelock are much less common a problem than deadlock, but are still problems that
 * every designer of concurrent software is likely to encounter.
 * <p>
 * Starvation
 * Starvation describes a situation where a thread is unable to gain regular access to shared resources and is
 * unable to make progress. This happens when shared resources are made unavailable for long periods by "greedy" threads.
 * For example, suppose an object provides a synchronized method that often takes a long time to return.
 * If one thread invokes this method frequently, other threads that also need frequent synchronized access to the
 * same object will often be blocked.
 * <p>
 * Livelock
 * A thread often acts in response to the action of another thread. If the other thread's action is also a response
 * to the action of another thread, then livelock may result. As with deadlock, livelocked threads are unable to make
 * further progress. However, the threads are not blocked — they are simply too busy responding to each other to resume
 * work. This is comparable to two people attempting to pass each other in a corridor: Alphonse moves to his left to let
 * Gaston pass, while Gaston moves to his right to let Alphonse pass. Seeing that they are still blocking each other,
 * Alphone moves to his right, while Gaston moves to his left. They're still blocking each other, so...
 * <p>
 * <p>
 * Recall that a thread cannot acquire a lock owned by another thread. But a thread can acquire a lock that it already owns.
 * Allowing a thread to acquire the same lock more than once enables reentrant synchronization. This describes a situation
 * where synchronized code, directly or indirectly, invokes a method that also contains synchronized code, and both sets
 * of code use the same lock. Without reentrant synchronization, synchronized code would have to take many additional
 * precautions to avoid having a thread cause itself to block.
 * <p>
 * <p>
 * <p>
 * <p>
 * Stady how to avoid it in SafeLock class
 */
public class Deadlock {
    static class Friend {
        private final String name;
        Random random = new Random();

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {    }
            System.out.format("%s: %s has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(() ->  {  alphonse.bow(gaston);   }).start();
        new Thread(() ->  {  gaston.bow(alphonse);   }).start();
    }

}
