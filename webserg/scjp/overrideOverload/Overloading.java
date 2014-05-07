package webserg.scjp.overrideOverload;

public class Overloading {
    static void go(int i) {
        System.out.println("int");
    }

    static void go(long i) {
        System.out.println("long");
    }

    static void go(Integer i) {
        System.out.println("Integer");
    }

    static void go(double i) {
        System.out.println("double");
    }

    /*static void go(Object o){
        System.out.println("object");
    }
    static void go(Object[] o){
        System.out.println("object[]");
    }*/
    static void go(String o) {
        System.out.println("string");
    }

    static void go(int[] o) {
        System.out.println("int []");
    }

    public static void main(String[] argv) {

        byte b = 1;
        short i = 1;
        long l = 2;
        float f = 2.3f;
        go(b);
        go(i);
        go(l);
        go(f);

        int k = 2;
        go(k);
        //go(new Integer[2]);
    }
}
