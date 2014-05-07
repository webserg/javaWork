package patterns.headFirstDesignPatterns.singleton.doubleCheck;

/**
 * Created by sergiy.doroshenko
 * Date: 10/22/11
 * <p/>
 * However, because the method is synchronized, you pay the cost of synchronization for every invocation of the method,
 * even though it is only required on the first invocation.
 * In an effort to make this method more efficient, an idiom called double-checked locking was created. The idea is to
 * avoid the costly synchronization for all invocations of the method except the first. The cost of synchronization
 * differs from JVM to JVM. In the early days, the cost could be quite high. As more advanced JVMs have emerged, the
 * cost of synchronization has decreased, but there is still a performance penalty for entering and leaving a
 * synchronized method or block.
 * Regardless of the advancements in JVM technology, programmers never want to waste processing time unnecessarily.
 */
public class Singleton {
    private static Singleton uniqueInstance;

    // other useful instance variables here

    private Singleton() {
    }

    /**
     * The code in Listing 3 exhibits the same problem as demonstrated
     * with multiple threads and Listing 1. Two threads can get inside
     * of the if statement concurrently when instance is null. Then,
     * one thread enters the synchronized block to initialize instance,
     * while the other is blocked. When the first thread exits the
     * synchronized block, the waiting thread enters and creates another
     * Singleton object. Note that when the second thread enters the synchronized block,
     * it does not check to see if instance is non-null
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }

    // other useful methods here
}
