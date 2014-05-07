package webserg.scjp.mock;

public class Init {
    X x = new X();

    Init() {
        System.out.println("constructor");
    }

    {
        System.out.println("init block");
    }

    static {
        System.out.println("stat");
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
