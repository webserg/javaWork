package thread.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * boolean compareAndSet(expectedValue, updateValue);
 * <p/>
 * This method (which varies in argument types across different classes) atomically sets a variable to the updateValue
 * if it currently holds the expectedValue, reporting true on success. The classes in this package also contain methods
 * to get and unconditionally set values, as well as a weaker conditional atomic update operation weakCompareAndSet
 * described below.
 * <p/>
 * weakCompareAndSet atomically reads and conditionally writes a variable but does not create any happens-before orderings,
 * so provides no guarantees with respect to previous or subsequent reads and writes of any variables other than the
 * target of the weakCompareAndSet
 */
public class UseCompareAndSwap {
    static int x = 0, y = 0;
    static int a = 0, b = 0;
    static AtomicBoolean bool = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                if (bool.get())
                    x = 1 / b; //guarantie b  will be 1
            }
        });
        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                bool.compareAndSet(false, true);  //if use weakCompareAndSet may be 1/0, but only theoritacly
                //I haven't achieve it practicly I don't know why
                y = a;
            }
        });
        other.start();
        one.start();
        one.join();
        other.join();
        System.out.println("( " + x + "," + y + ")");
    }
}