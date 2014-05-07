package webserg.scjp.overrideOverload;

import java.util.Date;

public class OverloadStaticMethod {
    Date d;
    int I[] = new int[10];

    public static void main(String[] argv) {

        B b = new B();
        int k = CCC.j;
        System.out.println(B._B);
        System.out.println("============");
        A a = new A();

        a = (B) b;
        a.echo("");
        a.echo();
        OverloadStaticMethod o = new OverloadStaticMethod();
        if (o.d == null)
            System.out.println("d instance varibale is null");
        System.out.println(o.I[0]);
        Date d = null;
        int I[] = new int[10];//array elements are given default values regardless of whether the array is declared
        System.out.println(I[0]);
        if (d == null)
            System.out.println("d is null");
    }
}

class A {
    static int _A = 1;

    A() {
        System.out.println("constr A");
    }

    public void echo() {
        System.out.println("A");
    }

    static {
        System.out.println("stat A");
    }

    static public void echo(String s) {
        System.out.println("A");
    }
}

class B extends A {
    static int _B = _A;

    B() {
        System.out.println("constr B");
    }

    {
        System.out.println("instans init");
    }

    static {
        System.out.println("stat B");
    }

    public void echo() {
        System.out.println("B");
    }

    static public void echo(String s) {
        System.out.println("B");
    }
}

class CCC {
    static int j = 1;

    static {
        System.out.println("stat C" + j);
    }

    static {
        System.out.println("without C");
    }
}