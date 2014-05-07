package webserg.scjp.overrideOverload;

public class BoxOrVarArg {
    static void go(Byte a, Byte b) {
        System.out.println("byte,byte");
    }

    ;

    static void go(Byte... a) {
        System.out.println("byte...");
    }

    ;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        byte b = 5;
        go(b, b);
    }
}
