package webserg.scjp.arrays;


import webserg.scjp.mock.IntegerGen;

public class Arrays {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final int[] i = new int[10];
        int[] j = new int[1];
        j = i;
        System.out.println(i[9]);
        System.out.println(Long.MAX_VALUE);
        i[6] = (int) Float.MAX_VALUE;
        System.out.println(i[6]);
        int[][] a = {{1, 2,}, {1,}, {,},};
        System.out.println(a[2].length);
        Integer[] o = new Integer[12];
        Object o6 = new Object[9];
        Object oo = o;
        Integer[] o2 = new Integer[1];
        o = o2;
        o2 = (Integer[]) o;

        for (int k = 0; k < o2.length; k++) {

        }
        int k = 3 / 2;
        System.out.println(k);

        int[] aa = {1, 2, 3, 4, 5, 6};
        int[] bb = {1, 2, 3};

       assert check(aa,bb);
       assert !check(aa,new int[]{2,5});

    }

    public static int method(int[]... args)[] {
        return args[0];
    }

    public static int[] method2(int[]... args) {
        return args[0];
    }

   static boolean check(int[] aa, int[] bb) {
        for (
                int p = 0;
                p <= bb.length; p++)

        {
            for (int m = 0; m <= aa.length; m++) {
                if (aa[m] == bb[p]) break;
                else if (m == aa.length) return false;
            }
        }
        return true;
    }

}
