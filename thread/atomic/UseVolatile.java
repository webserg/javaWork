package thread.atomic;

/**
 * volatile is a field modifier, while synchronized modifies code blocks and methods. So we can specify three variations of a simple accessor using those two keywords:
 * geti1() accesses the value currently stored in i1 in the current thread. Threads can have local copies of variables, and the data does not have to be the same as the data held in other threads. In particular, another thread may have updated i1 in it's thread, but the value in the current thread could be different from that updated value. In fact Java has the idea of a "main" memory, and this is the memory that holds the current "correct" value for variables. Threads can have their own copy of data for variables, and the thread copy can be different from the "main" memory. So in fact, it is possible for the "main" memory to have a value of 1 for i1, for thread1 to have a value of 2 for i1 and for thread2 to have a value of 3 for i1 if thread1 and thread2 have both updated i1 but those updated value has not yet been propagated to "main" memory or other threads.
 * <p>
 * On the other hand, geti2() effectively accesses the value of i2 from "main" memory. A volatile variable is not allowed to have a local copy of a variable that is different from the value currently held in "main" memory. Effectively, a variable declared volatile must have it's data synchronized across all threads, so that whenever you access or update the variable in any thread, all other threads immediately see the same value. Generally volatile variables have a higher access and update overhead than "plain" variables. Generally threads are allowed to have their own copy of data is for better efficiency.
 * <p>
 * Volatile Flow:
 * <p>
 * Get a global lock on the variable
 * Update the one variable from main memory
 * Write any change of the one variable back to main memory
 * Release the lock
 * Synchronized Flow:
 * <p>
 * Get a global lock on the monitor
 * Update all shared variables that have been accessed from main memory
 * Process some statements
 * Write all shared variables that have been changed back to main memory
 * Release the lock
 * There are two differences between volitile and synchronized.
 * <p>
 * Firstly synchronized obtains and releases locks on monitors which can force only one thread at a time to execute a code
 * block. That's the fairly well known aspect to synchronized. But synchronized also synchronizes memory.
 * In fact synchronized synchronizes the whole of thread memory with "main" memory. So executing geti3() does the
 * following:
 * <p>
 * The thread acquires the lock on the monitor for object this .
 * The thread memory flushes all its variables, i.e. it has all of its variables effectively read from "main" memory .
 * The code block is executed (in this case setting the return value to the current value of i3, which may have just been
 * reset from "main" memory).
 * (Any changes to variables would normally now be written out to "main" memory, but for geti3() we have no changes.)
 * The thread releases the lock on the monitor for object this.
 * So where volatile only synchronizes the value of one variable between thread memory and "main" memory, synchronized
 * synchronizes the value of all variables between thread memory and "main" memory, and locks and releases a monitor to
 * boot. Clearly synchronized is likely to have more overhead than volatile.
 */
public class UseVolatile {
    int i1;
    volatile int i2;
    int i3;

    int geti1() {
        return i1;
    }

    int geti2() {
        return i2;
    }

    synchronized int geti3() {
        return i3;
    }
}
