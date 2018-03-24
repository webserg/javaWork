package thread.exercises.goteborg.counter;

/**
 * Created by webserg on 03.05.2014.
 * he main method creates a Counter object and runs two threads on it, both running its run() method, which updates the shared counter.
 * After both threads have updated the counter 100000 times, they finish and its value is printed. The expected output is 200000. Compile and run the program.
 * The results that you get may depend on the hardware, operating system and the version of the Java environment. If you are running it on a multi-core machine,
 * it is quite likely that at least some of the runs will give different results than 200000.
 * The reason for this is that incrementing the counter is in fact not one basic operation, but two. Code counter++ gets compiled into something like this:
 * int tmp = counter;
 * counter = tmp + 1;
 * So while one thread is about to write the new value to the shared counter variable the other one might update it several times (
 * or even very many times) in the mean time. The Java standard does not guarantee that the threads will run synchronized in any way. And in fact they often are completely
 * unsynchronized and execute in a very surprising order. Whenever a particular order of executing code in different threads causes the program to
 * make an error, we call it a race condition. In this case it's a race condition between two threads reading and updating the same counter.
 */
class Counter implements Runnable {

    private final int rounds = 100000;
    private int counter = 0;

    public static void main(String[] args) {
        try {
            Counter c = new Counter();

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

    public void run() {
//    try {
        for (int i = 0; i < rounds; i++) {
            counter++;
        }
//    } catch (InterruptedException e) {
//      System.out.println ("Interrupted!");
//    }
    }
}
