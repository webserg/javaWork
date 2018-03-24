package webserg.init;


public class A1 {
    static {
        System.out.println("static block A1");
    }

    int t = 1;

    {
        System.out.println("init block A1");

    }

    public A1() {
        System.out.println("constructor A1");

    }
}