package patterns.headFirstDesignPatterns.singleton.dcl;

//
// Danger!  This implementation of Singleton not
// guaranteed to work prior to Java 5
//

/**
 * Another idea is to use the keyword volatile for the variables inst and instance.
 * According to the JLS (see Resources), variables declared volatile are supposed
 * to be sequentially consistent, and therefore, not reordered. But two problems
 * occur with trying to use volatile to fix the problem with double-checked locking:
 * The problem here is not with sequential consistency. Code is being moved, not reordered.
 * <p/>
 * Many JVMs do not implement volatile correctly regarding sequential consistency anyway.
 * The second point is worth expanding upon. Consider the code in Listing 9:
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
