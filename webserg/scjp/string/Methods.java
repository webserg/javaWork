package webserg.scjp.string;

public class Methods {

    public static void main(String[] argv) {
        String s = "0123456789";
        System.out.println(s.substring(5, 9));
        StringBuffer buf = new StringBuffer();
        String s1 = "abc";
        String s2 = "abc";
        s2 = s2.substring(0, 2).concat(" ").trim();
        System.out.println(s1 + "|");
        System.out.println(s2 + "|");
        System.out.println(s1 == s2);
        char c = s2.charAt(0);
        System.out.printf("%1$-4b|\n", false);
        System.out.println(s2.replace("abb", "b"));
        buf.append(s1);
        buf.insert(1, true);
        System.out.println(buf);
        System.out.println("this is a test".split("\\s").length);
        System.out.println('a' - 'b');


    }

}
