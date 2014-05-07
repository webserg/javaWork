package webserg.scjp.string;

public class StringBufferMethods {

    /**
     * @param args
     */
    public static void main(String[] args) {
        StringBuffer empty = new StringBuffer();
        StringBuffer nullString = null;
        empty.append(nullString);
        System.out.println(empty);
        StringBuffer s = new StringBuffer("start");
        s.append(" ").append("finish").reverse().insert(6, "!");
        System.out.println(s);

        StringBuffer d = new StringBuffer("0123456789");
        System.out.println(d.delete(2, 7));//01789

        StringBuffer s1 = new StringBuffer("abc");
        StringBuffer s2 = new StringBuffer("abc");
        System.out.println(s1 + " == " + s2 + " " + s1.equals(s2));

        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        System.out.println(sb1 + " == " + sb2 + " " + sb1.equals(sb2));
        StringBuilder sb3 = new StringBuilder("0123456789");
        String res = sb3.substring(1, 5);
        System.out.println(res);//1234
        sb3.append(0);
        sb3.delete(9, 10);
        System.out.println(sb3);
        StringBuilder del = new StringBuilder("012345");
        System.out.println(del.delete(1, 4));
        StringBuffer del2 = new StringBuffer("012345");
        System.out.println(del2.delete(1, 4));
    }
}
