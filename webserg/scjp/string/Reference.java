package webserg.scjp.string;

public class Reference {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "first";
        String n = new String("second");
        String n3 = new String("second");
        String n4 = "second";
        String n1 = "second";
        System.out.println(n == n1);
        System.out.println(n.equals(n1));
        System.out.println(n == n3);
        System.out.println(n1 == n4);
        String s2 = s;
        String n2 = n;
        String u1 = s2.toUpperCase();
        String u2 = n2.toUpperCase();
        System.out.println("s=" + s);
        System.out.println("s2=" + s2);
        System.out.println("n=" + n);
        System.out.println("n2=" + n2);
        System.out.println("u1=" + u1);
        System.out.println("u2=" + u2);
        System.out.println("s=" + s);
        System.out.println("s2=" + s2);
        System.out.println("n=" + n);
        System.out.println("n2=" + n2);
        s2 = s2.toUpperCase();
        n2 = n2.toUpperCase();
        System.out.println("s=" + s);
        System.out.println("s2=" + s2);
        System.out.println("n=" + n);
        System.out.println("n2=" + n2);
        String sd = "sd=";
        System.out.println(sd + sd.replace("s", "a") + sd);
    }
}
