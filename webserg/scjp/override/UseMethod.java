package webserg.scjp.override;

public class UseMethod {
    public static void main(String[] args) {
        Parent p = new Child();
        p.go(new A());
        p.on();
        p.go(new B());

        Child ch = new Child();

        ch.go(new B());
        Object obj = ch;
        obj.equals(ch);
        p.equals(ch);
        try {
            p.throwEx();
        } catch (MyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //p.go(new A());

        A a = new A();
        B b = new B();

        a = b;
        Object ob = "abc";
    }
}

class Parent {
    void go(A a) {
        System.out.println("Parent");
    }

    void on() {
        go(new B());
    }

    protected void throwEx() throws MyException {
        System.out.println("parent");
    }
}

class Child extends Parent {
    void go(A a) {
        System.out.println("child A");
    }

    void go(B a) {
        System.out.println("Child B");
    }

    public void throwEx() throws My2Exception {
        System.out.println("child");
    }

    public boolean equals(Object obj) {
        System.out.println(" equals(Object obj)");
        return true;
    }

}

class A {
}

class B extends A {
}

class MyException extends Exception {
}

class My2Exception extends MyException {
}
/**
 * child A
 * child A
 * child A
 * equals(Object obj)
 * equals(Object obj)
 * child
 */