package webserg.pazzlers.ch6;

/**
 * Java's overload resolution process operates in two phases.
 * The first phase selects all the methods or constructors that are accessible and applicable.
 * The second phase selects the most specific of the methods or constructors selected in the first phase.
 * One method or constructor is less specific than another if it can accept any parameters passed to the other
 * [JLS 15.12.2.5].
 * <p>
 * In our program, both constructors are accessible and applicable. The constructor Confusing(Object) accepts any parameter passed to Confusing(double[]), so Confusing(Object) is less specific. (Every double array is an Object, but not every Object is a double array.) The most specific constructor is therefore Confusing(double[]), which explains the program's output.
 */
public class Confusing {

    private Confusing(Object o) {
        System.out.println("Object");
    }

    private Confusing(double[] dArray) {
        System.out.println("double array");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Confusing(null);
    }

}
