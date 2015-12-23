// For week 1
// sestoft@itu.dk * 2014-08-20
package thread.ItUniversityCopenhagen.ex1;

import java.io.IOException;

public class TestLongCounter {
    public static void main(String[] args) throws IOException {
        final LongCounterSync lc = new LongCounterSync();
        Thread t = new Thread(() -> {
            while (true)        // Forever call increment
                lc.increment();

        });
        t.start();
        System.out.println("Press Enter to get the current value:");
        while (true) {
            System.in.read();         // Wait for enter key
            System.out.println(lc.get());
        }
    }
}

class LongCounterSync {
    private long count = 0;

    public synchronized void increment() {
        count = count + 1;
    }

    public synchronized long get() {
        return count;
    }
}
