package webserg.scjp.mock;

public class StringEq {
    public static void main(String[] args) {
        String s1 = "A";
        String s2 = "A";
        String s3 = new String(s1);
        String s4 = new String(s1);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
    }
}
