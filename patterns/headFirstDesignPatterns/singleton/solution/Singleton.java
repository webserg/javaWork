package patterns.headFirstDesignPatterns.singleton.solution;

import java.util.Vector;

/**
 * Created by sergiy.doroshenko
 * Date: 10/23/11
 * <p/>
 * The bottom line is that double-checked locking, in whatever form, should not be used because you
 * cannot guarantee that it will work on any JVM implementation. JSR-133 is addressing issues regarding
 * the memory model, however, double-checked locking will not be supported by the new memory model.
 * Therefore, you have two options:
 * Accept the synchronization of a getInstance() method as shown in Listing 2.
 * <p/>
 * Forgo synchronization and use a static field.
 */
public class Singleton {

    private static Singleton instance = new Singleton();
    private Vector v;
    private boolean inUse;

    private Singleton() {
        v = new Vector();
        inUse = true;
        //...
    }

    public static Singleton getInstance() {
        return instance;
    }
}
