package webserg.pazzlers.ch6;

public class CacheFix {
    private static boolean initialized = false;
    private static int sum;

    private static synchronized void initializeIfNecessary() {
        if (!initialized) {
            for (int i = 0; i < 100; i++)
                sum += i;
            initialized = true;
        }
    }

    public static int getSum() {
        initializeIfNecessary();
        return sum;
    }


}
