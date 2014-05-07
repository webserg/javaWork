package webserg.scjp.devel;

/**
 * User: Sergiy Doroshenko
 * Date: 12/23/10 9:01 PM
 */
public class TryCatchFinal {
    public static void main(String[] args) {

        try {
            TryCatchFinal.method();
        } catch (RuntimeException e) {
            return;
        } finally {
            throw new IllegalArgumentException();
        }
    }

    static void method() throws RuntimeException {
        try {
            throw new IllegalStateException();
            //return;   //compile time error
        } finally {
            throw new IllegalArgumentException();
        }
    }
}
