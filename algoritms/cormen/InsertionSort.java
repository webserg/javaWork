package algoritms.cormen;

import java.util.Arrays;

/**
 * Created by webserg on 10/3/2016.
 * Insertion sort by Cormen
 * We start by presenting the INSERTION-SORT procedure with the time “cost”
 * of each statement and the number of times each statement is executed
 * we let tj denote the number of times the
 * while loop test in line 5 is executed for that value of j. When a for or while loop
 * exits in the usual way (i.e., due to the test in the loop header), the test is executed
 * one time more than the loop body.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[]{5, 4, 3, 2, 1};
        int tt = 0;// number
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            int t = 1;
            while (i >= 0 && a[i] > key) {
                t++;
                a[i + 1] = a[i];
                i--;
            }
            System.out.println("t=" + t);
            tt += t;
            a[i + 1] = key;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(tt);
        int[] c = new int[]{1, 2, 3, 4, 5};
//        Arrays.deepEquals(c, a);
    }
}
