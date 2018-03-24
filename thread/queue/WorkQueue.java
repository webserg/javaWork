package thread.queue;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sergiy Doroshenko
 * <p>
 * Effective java first edition Item 50
 */
public abstract class WorkQueue {

    private final List<Runnable> queue = new LinkedList<Runnable>();

    private boolean stopped = false;

    protected WorkQueue() {
        new WorkerThread().start();
    }

    public final void enqueue(Runnable workItem) {
        synchronized (queue) {
            System.out.println("added" + workItem);
            queue.add(workItem);
            queue.notify();

        }
    }

    public final void enqueue(Collection<Runnable> workItems) {
        synchronized (queue) {
            queue.addAll(workItems);
            queue.notify();
        }
    }

    public final void stop() {
        synchronized (queue) {
            stopped = true;
            queue.notify();
        }
    }

    protected abstract void processItem(Runnable workItem) throws InterruptedException;

    // Broken - invokes alien method from synchronized block!
    private class WorkerThread extends Thread {

        public void run() {
            while (true) { // PeriodictskExecution loop
                synchronized (queue) {
                    try {
                        while (queue.isEmpty() && !stopped) {
                            queue.wait();
                            System.out.println("wait...");
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                    if (stopped)
                        return;
                    Runnable workItem = queue.remove(0);
                    new Thread(workItem).start(); // Lock held!
                }
            }
        }
    }
}
