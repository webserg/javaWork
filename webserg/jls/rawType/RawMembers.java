package webserg.jls.rawType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * User: webserg
 * Date: 21.11.12
 * The supertype of a class may be a raw type. Member accesses for the class are
 * treated as normal, and member accesses for the supertype are treated as for raw
 * types. In the constructor of the class, calls to super are treated as method calls on
 * a raw type.
 * The use of raw types is allowed only as a concession to compatibility of legacy
 * code. The use of raw types in code written after the introduction of generics into
 * the Java programming language is strongly discouraged. It is possible that future
 * versions of the Java programming language will disallow the use of raw types.
 * To make sure that potential violations of the typing rules are always flagged, some
 * accesses to members of a raw type will result in compile-time unchecked warnings.
 * The rules for compile-time unchecked warnings when accessing members or
 * constructors of raw types are as follows:
 * • At an assignment to a field: if the type of the left-hand operand is a raw type, then
 * a compile-time unchecked warning occurs if erasure changes the field's type.
 * • At an invocation of a method or constructor: if the type of the class or interface to
 * search (§15.12.1) is a raw type, then a compile-time unchecked warning occurs if
 * erasure changes any of the formal parameter types of the method or constructor.
 * • No compile-time unchecked warning occurs for a method call when the formal
 * parameter types do not change under erasure (even if the result type and/or
 * throws clause changes), for reading from a field, or for a class instance creation
 * of a raw type.
 */
class NonGeneric {
    Collection<Number> myNumbers() {
        return null;
    }
}

public abstract class RawMembers<T> extends NonGeneric
        implements Collection<String> {
    static Collection<NonGeneric> cng = new ArrayList<NonGeneric>();

    public static void main(String[] args) {
        RawMembers rw = null;
        Collection<Number> cn = rw.myNumbers();
// OK
        Iterator<String> is = rw.iterator();
// Unchecked warning
        Collection<NonGeneric> cnn = rw.cng;
// OK, static member
    }
}
