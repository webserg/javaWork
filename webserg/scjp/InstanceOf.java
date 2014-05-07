package webserg.scjp;

public class InstanceOf {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        B a = new B();
        Object o = (Object) a;
        if (o instanceof A) {

            System.out.println("ok");
        }
    }

}

class A {
}

class B extends A {
}
