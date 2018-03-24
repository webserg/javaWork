package webserg.jls.rawType;

/**
 * User: webserg
 * Date: 21.11.12
 * <p/>
 * To facilitate interfacing with non-generic legacy code, it is possible to use as a type
 * the erasure (§4.6) of a parameterized type (§4.5) or the erasure of an array type
 * (§10.1) whose element type is a parameterized type. Such a type is called a raw
 * type.
 * More precisely, a raw type is defined to be one of:
 * • The reference type that is formed by taking the name of a generic type declaration
 * without an accompanying type argument list.
 * • An array type whose element type is a raw type.
 * • A non-static member type of a raw type R that is not inherited from a superclass
 * or superinterface of R.
 */
public class Cell<E> {
    E value;

    Cell(E v) {
        value = v;
    }

    public static void main(String[] args) {
        Cell x = new Cell<String>("abc");
        System.out.println(x.value); // OK, has type Object
        System.out.println(x.get()); // OK, has type Object
        x.set("def"); // unchecked warning
    }

    E get() {
        return value;
    }

    void set(E v) {
        value = v;
    }
}
