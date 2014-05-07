package webserg.scjp.overrideOverload;

public class OverloadOverBoxing {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i = 1;
        go(i, i);
    }

    static void go(Integer... i) {
        System.out.println("Integer " + i[0] + "" + i[1]);
    }

    static void go(int... i) {
        System.out.println(i[0] + "" + i[1]);
    }

    static void go(Integer i, Integer k) {
        System.out.println("integer,integer");
    }

    static void go(Long i, Long k) {
        System.out.println("long,long");
    }

    static void go(Integer i) {
        System.out.println("Integer");
    }
}
