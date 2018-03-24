package webserg.jls.classes;

/**
 * 189
 * Any local variable used but not declared in an inner class must be definitely
 * assigned (§16) before the body of the inner class.
 * A blank final (§4.12.4) field of a lexically enclosing class may not be assigned
 * within an inner class, or a compile-time error occurs.
 * <p>
 * The declaration of class LocalInStaticContext occurs in a static context due to being
 * within the static method classMethod. Instance variables of class Outer are not available
 * within the body of a static method. In particular, instance variables of Outer are not
 * available inside the body of LocalInStaticContext. However, local variables from the
 * surrounding method may be referred to without error (provided they are marked final).
 * <p>
 * User: webserg
 * Date: 19.12.12
 */
public class OuterClassDeclaration {
    int i = 100;

    static void classMethod() {
        final int l = 200;

        class LocalInStaticContext {
            //      int k = i; // Compile-time error
            int m = l; // OK
        }

    }

    void foo() {
        class Local { // A local class
            int j = i;
        }
    }
}
