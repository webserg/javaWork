package java16;

public class C implements A, B {
    @Override
    public void hello() {
        B.super.hello();
    }

    public static void main(String[] args) {
        var c = new C();
        c.hello();

    }

}
