package webserg.scjp.overrideOverload;

public class TestOverloadWide {
    /*static void test(byte b){
        System.out.println("byte");
    }*/
    static void test(char b) {
        System.out.println("char");
    }

    /*static void test(short b){
        System.out.println("short");
    }
    static void test(int b){
        System.out.println("int");
    }
    static void test(long b){
        System.out.println("long");
    }

    static void test(float b){
        System.out.println("float");
    }
    static void test(double b){
        System.out.println("double");
    }*/
    static void test(int i, int... js) {
        System.out.println("...");
    }

    ;

    /**
     * @param args
     */
    public static void main(String[] args) {
        int b = 7;
        test(b);

    }

}
