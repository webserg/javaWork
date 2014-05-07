package webserg.scjp.devel;

public class ClassBadFinal {
    static final int i = 1;

    static void go(int h) {
        System.out.println(++h);
    }

    public static void main(String[] argv) {
        go(i);
        System.out.println();
        final int j = 2;
    }
}
