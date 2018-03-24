package patterns.headFirstDesignPatterns.singleton.classic;

// NOTE: This is not thread safe!

/**
 * 1. Thread 1 calls the getInstance() method and determines that instance is null at //1.
 * 2.Thread 1 enters the if block, but is preempted by thread 2 before executing the line at //2.
 * 3.Thread 2 calls the getInstance() method and determines that instance is null at //1.
 * 4.Thread 2 enters the if block and creates a new Singleton object and assigns
 * the variable instance to this new object at //2.
 * 5.Thread 2 returns the Singleton object reference at //3.
 * 6.Thread 2 is preempted by thread 1.
 * 7.Thread 1 starts where it left off and executes line //2 which results in another Singleton object being created.
 * 8.Thread 1 returns this object at //3.
 */
public class Singleton {
    private static Singleton uniqueInstance;

    // other useful instance variables here

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {  //1
            uniqueInstance = new Singleton(); //2
        }
        return uniqueInstance; //3
    }

    // other useful methods here
}
