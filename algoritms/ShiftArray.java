package algoritms;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Shift array
 *
 * @author Sergiy Doroshenko
 */
public class ShiftArray extends TestCase {

    private static String[] source = {"a", "b", "c", "d", "e", "f", "g", "h"};

    private static String[] result = {"d", "e", "f", "g", "h", "a", "b", "c"};

    private static void swap(String s[], int i, int j) {
        String t;
        while (i < j) {
            t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }

    public void testRotate() {
        int shift = 3;
        System.out.println(Arrays.toString(source));

        String[] s = rotate(Arrays.copyOf(source, source.length), shift);
        System.out.println(Arrays.toString(s));
        assertTrue(Arrays.deepEquals(result, s));
    }

    /*
     * The Idea:
     * Change AB to BA
     * If A is shorter, divide B into B1  and B2 .
     * where B2 has as many elements as A
     * Swap A and B2 to change AB1B2 into B2B1A.
     * Recur on pieces of b.
     */

    public void testSwapShift() {
        int shift = 3;
        System.out.println(Arrays.toString(source));
        String[] s = swapShift(Arrays.copyOf(source, source.length), shift);
        System.out.println(Arrays.toString(s));
        assertTrue(Arrays.deepEquals(result, s));
    }

    // The Code /* rotate abcdefgh left three */
    //                 /* abcdefgh */
    // reverse(0, d-1) /* cbadefgh */
    // reverse(d, n-1) /* cbahgfed */
    // reverse(0, n-1) /* defghabc */
    /*
     * @param s @param shift @return
     */
    private String[] swapShift(String[] s, int shift) {
        int n = s.length;
        swap(s, 0, shift - 1);
        swap(s, shift, n - 1);
        swap(s, 0, n - 1);
        return s;
    }

    private String[] rotate(String[] s, int shift) {
        String t = null;
        int j = 0;
        int k = 0;
        int n = s.length;
        for (int i = 0; i < GeneralCommonDel.gcd2(shift, n); i++) {
            t = s[i];
            j = i;
            while (true) {
                k = j + shift;
                if (k >= n)
                    k -= n;
                if (k == i)
                    break;
                s[j] = s[k];
                j = k;
            }
            s[j] = t;
        }
        return s;
    }

}
