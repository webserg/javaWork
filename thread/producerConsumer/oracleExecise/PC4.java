package thread.producerConsumer.oracleExecise;

/**
 * Let's use guarded blocks to create a Producer-Consumer application. This kind of application shares data
 * between two threads: the producer, that creates the data, and the consumer, that does something with it.
 * The two threads communicate using a shared object. Coordination is essential: the consumer thread must not
 * attempt to retrieve the data before the producer thread has delivered it,
 * and the producer thread must not attempt to deliver new data if the consumer hasn't retrieved the old data.
 *
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/16/11 1:47 PM
 */
public class PC4 {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
