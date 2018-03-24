package thread.exercises.exercise1;

public class Fun extends Thread {

    /**
     * You must arrange for each {@link Fun} object to assign itself
     * a unique integer in sequence.  Use a static variable for
     * this purpose.  Why is the assignment of the id not a source
     * of trouble for multithreading?
     */
    public Fun(SwapUm s) {
    }

    /**
     * Return the unique id of this object, as set in the constructor.
     */
    public int getID() {
        return 0;  // FIX
    }

    /**
     * Write a loop that 10 times does the following:
     * <OL> <LI> Calls {@link SwapUm#swap()} on the {@link SwapUm} object
     * <LI> Obtains {@link SwapUm#getSum()}
     * <LI> Throws a new {@link Error} if the sum is not right.
     * </OL>
     */
    public void run() {
    }
}


