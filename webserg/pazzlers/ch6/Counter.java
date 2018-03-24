package webserg.pazzlers.ch6;

public class Counter {
    // if you need a separate copy for each subclass, you must declare a separate static field in each subclass
    private static int count;

    public static void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }

}
