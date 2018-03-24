package webserg.init;

public class InitBlock {

    static final int f = 1;
    static final int g = T.prt("init final field");
    static int c = T.prt("init static filed");
    static int h = T.prt("init static filed h");

    static {
        System.out.println("1st static init");
    }

    static {
        System.out.println("2nd static init");
    }

    static {
        System.out.println("c=" + c);
        System.out.println("f=" + f);
    }

    {
        System.out.println("1st instance init");
    }

    {
        System.out.println("2nd instance init");
    }

    InitBlock(int x) {
        System.out.println("1-arg const");
        c = x;
    }

    InitBlock() {
        System.out.println("no-arg const");
    }

    public static void main(String[] args) {
        //int k = InitBlock.c;
        //new InitBlock();
        new InitBlock(7);
        //System.out.println("k = " + InitBlock.c);
    }


}

class T {
    static int prt(String s) {
        System.out.println(s);
        return 1;
    }
}