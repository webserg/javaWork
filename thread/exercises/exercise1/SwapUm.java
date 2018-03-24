package thread.exercises.exercise1;

/**
 * This class is provided for you but is not thread-safe.  You must
 * modify it to be thread-safe and explain answers to the questions in
 * the files for this lab
 */
public class SwapUm {
    private int x;
    private int y;

    /**
     * Initially, x and y are 0 and 1, respectively.
     */
    public SwapUm() {
        x = 0;
        y = 1;
    }

    /**
     * The swap method described in class, with a pause between
     * swaps.  Questions you must answer:
     * <OL>
     * <LI> What happens if you change or eliminate the sleep time?
     * <LI> How can you modify the methods of this class to be thread-safe
     * (you must leave the sleep in!)
     * </OL>
     */
    public void swap() {
        int temp = x;
        x = y;
        Exercise1.sleep(100);
        y = temp;
    }


    /**
     * Returns the sum of x and y
     */
    public int getSum() {
        return x + y;
    }

}
