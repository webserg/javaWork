package webserg.jls.classes;

/**
 * Any local variable, formal parameter, or exception parameter used but not declared
 in an inner class must be declared final.
 * User: webserg
 * Date: 19.12.12
 */
public class HasStatic {
    static int j = 100;
}

class Outer {
    class Inner extends HasStatic {
        static final int x = 3; // OK: compile-time constant
        //static int y = 4; // Compile-time error: an inner class
    }

    static class NestedButNotInner {
        static int z = 5; // OK: not an inner class
    }

    interface NeverInner {
    } // Interfaces are never inner
}
