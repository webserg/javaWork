package javaCap;

public class Operators {
    public static void main(String[] args) {
        System.out.println(x1() ^ x2());
        System.out.println(x1() | x2());
        System.out.println(x1() || x2());
        System.out.println(x1() & x2());
        System.out.println(x1() && x2());
    }

    static boolean x1(){
        System.out.print("x1");
        return true;
    }

    static boolean x2(){
        System.out.println("x2");
        return false;
    }
}
