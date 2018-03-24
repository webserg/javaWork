package webserg.boxing;

public class BoxOrVarargs {

    static void go(Byte b, Byte c) {
        System.out.println("byte,byte");
    }

    static void go(Byte... x) {
        System.out.println("byte...");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        byte b = 1;
        go(b, b);

    }

}
