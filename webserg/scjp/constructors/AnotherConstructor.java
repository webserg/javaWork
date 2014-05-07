package webserg.scjp.constructors;

public class AnotherConstructor extends A {
    static int k;

    static {
        System.out.println("only one static " + k);
    }

    public AnotherConstructor() {
        System.out.println("no param");
    }

    public AnotherConstructor(String s) {
        this();
    }

    {
        System.out.println("only one " + k);
    }

    void go() {
        //AnotherConstructor();// can not invoke constructor
    }

    B[] useB() {
        return new G[10];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("begin");
        AnotherConstructor a = new AnotherConstructor("");
        G g = new G("");

    }

}

class A {
    A() {
        System.out.println(" A ");
    }
}

abstract class _A {
    _A() {
        System.out.println("abstract");
    }
}

class B extends _A {
    B(String s) {
        System.out.println(" B " + s);
    }
}

/*class C extends B{ Error compiler. Must define an explicit constructor

}*/
class G extends B {
    G() {
        super("");
    }

    G(String s) {
        this();
        System.out.println("G");


    }
}
