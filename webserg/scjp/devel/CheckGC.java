package webserg.scjp.devel;

import java.util.Date;

public class CheckGC {
    static final int f = 1;
    int k = 1;

    /**
     * @param args
     */
    public static void main(String[] args) {
        final CheckGC g = new CheckGC();
        g.k = 2;

        System.out.println(g.k);
        int[] a[];
        Object c = new long[4];
        Runtime rt = Runtime.getRuntime();
        System.out.println("1:total:" + rt.totalMemory());
        System.out.println("2:free:" + rt.freeMemory());
        Date d = null;
        for (int i = 0; i <= 10000; i++) {
            d = new Date();
            d = null;

        }
        System.out.println("3:free:" + rt.freeMemory());
        rt.gc();
        System.out.println("4:free:" + rt.freeMemory());

    }

}
