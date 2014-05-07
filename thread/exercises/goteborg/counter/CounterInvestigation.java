package thread.exercises.goteborg.counter;

/**
 * Created by webserg on 03.05.2014.
 */
public class CounterInvestigation implements Runnable {
    private int counter = 0;
    private final int rounds = 100000;

    public void run() {
        int id;
        String name = Thread.currentThread().getName();
        if (name.equals("thread1")) id = 1;
        else id = 2;
        try {
            for (int i = 0; i < rounds; i++) {
                int tmp = counter;
                counter = tmp + 1;
                if (id == 1 && i == 200) Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }
    }

    public static void main(String[] args) {
        try {
            CounterInvestigation c = new CounterInvestigation();

            // Create two threads that run our run () method.
            Thread t1 = new Thread(c, "thread1");
            Thread t2 = new Thread(c, "thread2");

            t1.start();
            t2.start();

            // Wait for the threads to finish.
            t1.join();
            t2.join();

            // Print the counter
            System.out.println(c.counter);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }
    }
}
