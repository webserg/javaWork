package thread.producerConsumer.oracleExecise.oracleExeciseSolution;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/16/11 1:52 PM
 */
public class PC5 {
    public static void main(String[] args) {
        BlockingQueue<String> drop = new SynchronousQueue<String>();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
