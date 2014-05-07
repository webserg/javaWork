package webserg.scjp.devel;

public class Comparison {

    /**
     * @param args
     */
    public static void main(String[] args) {
        float f = 1.2f;
        double d = 1.1;
        int i = 2;
        long l = 1L;
        char c = 'c';
        byte b = (byte) 2;
        byte bb = 2 + 12;
        boolean bool = true;
        System.out.println(f == c);
        System.out.println(d == l);
        System.out.println(i == c);
        System.out.println(b == c);
        System.out.println(b == i);

        //System.out.println(bool==c);

    }

}
