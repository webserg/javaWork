package webserg.scjp;

public class Printf {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i1 = -123;
        int i2 = 001234567;
        System.out.printf(">%2$-10d %1$+d<\n", i1, i2);
        System.out.format(">%+-10d %d<\n", i1, i2);
        System.out.format(">%1$+d\n", i1, i2);
        System.out.format(">%20d<", new Long(1234567891234567l));
    }

}
