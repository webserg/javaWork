package webserg.pazzlers.ch6;

/**
 * @author Sergiy Doroshenko
 * Use either eager or lazy initialization never both
 */
public class Cache {

    private static int sum;
    private static boolean initialized = false;//static fields must appears before any initializers that depend on it

    static {
        initializeIfNecessary();
    }

    public static int getSum() {
        initializeIfNecessary();
        return sum;
    }

    private static synchronized void initializeIfNecessary() {
        if (!initialized) {
            for (int i = 0; i < 100; i++)
                sum += i;
            initialized = true;
        }
    }
}
