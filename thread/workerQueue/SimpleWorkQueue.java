package thread.workerQueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * SimpleWorkQueue class initializes a dequeue and starts a fixed number of threads at startup.
 * Each thread then executes queue.takeLast()
 * in a loop that retrieves a task from the worker queue (if there are tasks) or waits
 * for a new task to arrive (if it finds the queue is empty).
 * Once a task is retrieved, each thread then calls the run method, r.run(),
 * of the task.
 * <p>
 * <p>
 * Created by sergiy.doroshenko
 * Date: 7/11/11
 */
public class SimpleWorkQueue {
    private final PoolWorker[] threads;
    private final BlockingDeque<Task> queue;
    volatile public boolean stopNow = false;
    int totalTasks;
    int nThreads;

    public SimpleWorkQueue(int nThreads, int totalTasks) {
        queue = new LinkedBlockingDeque<Task>(totalTasks);
        threads = new PoolWorker[nThreads];
        this.nThreads = nThreads;
        this.totalTasks = totalTasks;
    }

    public void runThreads() {
        for (int i = 0; i < this.nThreads; i++) {
            threads[i] = new PoolWorker("" + i);
            threads[i].start();
        }
    }

    public void addTasks() {
        for (int i = 0; i < this.totalTasks; i++) {
            queue.addLast(new Task("" + i));
        }
    }

    /*
     * Worker thread to execute remote tasks
     */
    private class PoolWorker extends Thread {
        private PoolWorker(String name) {
            super(name);
        }

        /*
         * Method to retrieve task from worker queue and start executing it.
         * This thread will wait for a task if there is no task in the queue.
         */
        public void run() {
            while (!stopNow) {
                try {
                    System.out.println("thread number " + this.getName() + " started work");
                    Task r = queue.take();
                    System.out.println("task #" + r.getName());
                    r.run();
                    System.out.println("thread number " + this.getName() + " finished work");
                } catch (java.lang.Throwable e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
