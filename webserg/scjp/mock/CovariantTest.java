package webserg.scjp.mock;

public class CovariantTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        CovariantTest t = new SubCovariantTest();
        System.out.println(t.getObj().i);

    }

    A getObj() {
        System.out.println("CovariantTest");
        return new A();
    }

}

class SubCovariantTest extends CovariantTest {
    B getObj() {
        System.out.println("SubCovariantTest");
        return new B();
    }
}

class A {
    int i = 5;

    private void t() {
    }

    ;
}

class B extends A {
    int i = 6;

    public synchronized void t() {
    }

    ;
}