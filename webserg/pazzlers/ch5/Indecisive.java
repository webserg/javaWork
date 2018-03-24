package webserg.pazzlers.ch5;

/**
 * This poor little program can't quite make up its mind.
 * The decision method returns true. But it also returns false. What does it print? Is it even legal?
 * <p/>
 * You might think that this program is illegal. After all, the decision method can't return both TRue and false.
 * If you tried it, you found that it compiles without error and prints false. Why?
 * <p/>
 * The reason is that in a try-finally statement, the finally block is always executed when control leaves
 * the try block [JLS 14.20.2]. This is true whether the try block completes normally or abruptly. Abrupt completion of
 * a statement or block occurs when it throws an exception, executes a break or continue to an enclosing statement,
 * or executes a return from the method as in this program. These are called abrupt completions because they prevent
 * the program from executing the next statement in sequence.
 * <p>
 * In summary, every finally block should complete normally, barring an unchecked exception.
 * Never exit a finally block with a return, break, continue, or tHRow, and never allow a checked
 * exception to propagate out of a finally block.
 */
public class Indecisive {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(decision());
    }

    private static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }

}
