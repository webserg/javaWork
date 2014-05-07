package thread.atomic;

/**
 * Assume that one thread is calling writer, and another is calling reader. The write to v in writer releases the
 * write to x to memory, and the read of v acquires that value from memory. Thus, if the reader sees the value true
 * for v, it is also guaranteed to see the write to 42 that happened before it. This would not have been true under
 * the old memory model.  If v were not volatile, then the compiler could reorder the writes in writer, and reader's
 * read of x might see 0.
 * Effectively, the semantics of volatile have been strengthened substantially, almost to the level of synchronization.
 * Each read or write of a volatile field acts like "half" a synchronization, for purposes of visibility.
 * Important Note: Note that it is important for both threads to access the same volatile variable in order to properly
 * set up the happens-before relationship. It is not the case that everything visible to thread A when it writes volatile
 * field f becomes visible to thread B after it reads volatile field g. The release and acquire have to "match"
 * (i.e., be performed on the same volatile field) to have the right semantics.
 */
class Edge2 {
    int x = 0;
    volatile  boolean v = false;

    public void writer() {
        x = 42;   //happens-before
        v = true;  //without volatile it can be reordered
    }

    public void reader() {
        if (v) {
            //uses x - guaranteed to see 42.
            System.out.println(x);
        }
    }

    public boolean isV() {
        return v;
    }

    public int getX() {

        return x;
    }
}

public class UseVolatile2 {
    public static void main(String[] args) throws InterruptedException {
        final Edge2 edge = new Edge2();

        Thread one = new Thread(new Runnable() {
            public void run() {
                edge.reader();
            }
        });
        Thread other = new Thread(new Runnable() {
            public void run() {
                edge.writer();
            }
        });
                other.start();
        one.start();
        one.join();
        other.join();
        System.out.println("( " + edge.getX() + "," + edge.isV() + ")");
    }
}
