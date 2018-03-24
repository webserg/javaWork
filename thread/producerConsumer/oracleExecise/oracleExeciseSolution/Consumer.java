package thread.producerConsumer.oracleExecise.oracleExeciseSolution;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/16/11 1:53 PM
 */
class Consumer implements Runnable {
    private BlockingQueue<String> drop;

    Consumer(BlockingQueue<String> drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        try {
            for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
                System.out.format("MESSAGE RECEIVED: %s%n", message);
                Thread.sleep(random.nextInt(5000));

            }
        } catch (InterruptedException e) {
        }
    }
}
