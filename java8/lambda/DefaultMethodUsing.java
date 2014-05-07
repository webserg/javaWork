package java8.lambda;
/**
 * In order to solve  backward compatibility limitation new mechanism was invented.
 * The default methods mechanism works by modifying class loading
 * <p/>
 * methods are as follows:
 * â– â–  Any implementation of the interface  may (but is not required to)
 * implement a default method.
 * â– â–  If an implementing class implements a default method, the
 * implementation in the class is used.
 * â– â–  If an implementing class does not implement a default
 * method, the default implementation
 * (from the interface definition)
 * is used.
 * <p/>
 * Any implementation of the interface  may (but is not required to)
 * implement a default method. If an implementing class implements
 * a default method, the implementation in the class
 * is used.      If an implementing class
 * does not implement a default method, the default implementation
 * (from the interface definition) is used.
 * Letâ€™s take a quick look at an *
 * The default-methods mechanism works by modifying class
 * loading. When an implementation  of an interface is being loaded,
 * the class file is examined to see whether all the optional methods
 * are present. If they are, class loading
 * continues normally. If they are
 * not, the byte code of the implementation
 * is patched to add in
 * the default implementation of the
 * missing methods.
 * Default methods represent a      fundamental change in Javaâ€™s
 * approach to object orientation. From Java 8 onward, interfaces
 * can contain implementation code. Many developers see this as relaxing
 * some of Javaâ€™s strict single inheritance rules.                       There is one detail about how
 * default methods work that developers should understand: the
 * possibility of default implementation clash. If an implementing
 * class already has a method that       has the same name and signature
 * as a new default method, the   pre-existing implementation will
 * always be used in preference to the default implementation.
 *
 */
public class DefaultMethodUsing {
    public static void main(String[] args) {

    }
}
