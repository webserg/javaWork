package webserg.init;

public class B1 extends A1 {
    static {
        System.out.println("static block B1");

    }

    int k = p();
    private int publ = 7;

    {
        System.out.println("init block B1 ");
    }

    {
        System.out.println("init t = " + t);
    }

    {
        System.out.println("init " + k);
    }


    public B1() throws Exception {
        System.out.println("constructor B1" + k);
    }

    static int p() {
        System.out.println("p");
        return 1;
    }

    public static void main(String[] args) throws Exception {
        B1 b1 = new B1();
        int k = 0, j = 0;


        try {
            int i = k / j++;
            System.out.println(i);
        } catch (java.lang.ArithmeticException e) {
            System.out.println("ArithmeticException ");
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(b1.publ);
    }

    class Inne {
        void f() {
            System.out.println(B1.this.k);
        }
    }
}