package thread.ItUniversityCopenhagen.ex3;// For week 3
// sestoft@itu.dk * 2014-08-25

import net.jcip.annotations.GuardedBy;

import java.io.IOException;

public class ThreadsafeLongCounter {
    public static void main(String[] args) throws IOException {
        final LongCounter lc = new LongCounter();
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true)        // Forever call increment
                    lc.increment();
            }
        });
        t.start();
        System.out.println("Press Enter to get the current value:");
        while (true) {
            System.in.read();         // Wait for enter key
            System.out.println(lc.get());
        }
    }
}

class LongCounter {
    @GuardedBy("this")
    private long count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized long get() {
        return count;
    }
}
