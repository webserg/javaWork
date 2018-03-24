package webserg.scjp.mock;

public class Init {
    static {
        System.out.println("stat");
    }

    X x = new X();

    {
        System.out.println("init block");
    }

    Init() {
        System.out.println("constructor");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("main");
        new Init();
    }

}

class X {
    X() {
        System.out.println("X");
    }

    ;
}
