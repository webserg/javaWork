package collections.queue;

import java.util.concurrent.BlockingDeque;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 22, 2010
 * Time: 12:44:20 PM
 */
public class Producer implements Runnable {
    String name;
    private BlockingDeque<Integer> deque;

    public Producer(String name, BlockingDeque<Integer> deque) {
        this.name = name;
        this.deque = deque;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                deque.putFirst(i);
                System.out.println("put = " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
