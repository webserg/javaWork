package thread.producerConsumer.oracleExecise;

import java.util.Random;

/**
 * @author Sergiy Doroshenko
 *         email:webserg@gmail.com
 *         Date: 1/16/11 1:40 PM
 */
class Consumer implements Runnable{
     private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (String message = drop.take(); ! message.equals("DONE");
                message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}
