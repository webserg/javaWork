package patterns.headFirstDesignPatterns.singleton.doubleCheck;

/**
 * Created by sergiy.doroshenko
 * Date: 10/23/11
 * <p/>
 * public static Singleton getInstance()
 * {
 * if (instance == null)
 * {
 * synchronized(Singleton.class) {
 * instance = new Singleton();
 * }
 * }
 * return instance;
 * }
 * <p/>
 * The code in Listing 3 exhibits the same problem as demonstrated with multiple threads and Listing 1.
 * Two threads can get inside of the if statement concurrently when instance is null.
 * Then, one thread enters the synchronized block to initialize instance, while the other is blocked.
 * When the first thread exits the synchronized block, the waiting thread enters and creates another Singleton object.
 * Note that when the second thread enters the synchronized block, it does not check to see if instance is non-null.
 * <p/>
 * The theory behind double-checked locking is that the second check at //2 makes it impossible for two
 * different Singleton objects to be created as occurred in Listing 3.
 * <p/>
 * 1.Thread 1 enters the getInstance() method.
 * 2.Thread 1 enters the synchronized block at //1 because instance is null.
 * 3.Thread 1 is preempted by thread 2.
 * 4.Thread 2 enters the getInstance() method.
 * 5.Thread 2 attempts to acquire the lock at //1 because instance is still null. However, because thread 1 holds the lock,
 * thread 2 blocks at //1.
 * 6.Thread 2 is preempted by thread 1.
 * 7.Thread 1 executes and because instance is still null at //2, creates a Singleton object and assigns its
 * reference to instance.
 * 8.Thread 1 exits the synchronized block and returns instance from the getInstance() method.
 * 9.Thread 1 is preempted by thread 2.
 * 10.Thread 2 acquires the lock at //1 and checks to see if instance is null.
 * 11.Because instance is non-null, a second Singleton object is not created and the one created by thread 1 is returned
 * <p/>
 * The theory behind double-checked locking is perfect. Unfortunately, reality is entirely different.
 * The problem with double-checked locking is that there is no guarantee it will work on single or multi-processor machines.
 * The issue of the failure of double-checked locking is not due to implementation bugs in JVMs but to the current
 * Java platform memory model. The memory model allows what is known as "out-of-order writes" and is a prime reason
 * why this idiom fails.
 */
public class SingletonFixed {
    private static SingletonFixed uniqueInstance;

    public static SingletonFixed getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonFixed.class) {  //1
                if (uniqueInstance == null)          //2
                    uniqueInstance = new SingletonFixed();  //3
            }
        }
        return uniqueInstance;
    }
}
