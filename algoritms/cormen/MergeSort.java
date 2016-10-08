package algoritms.cormen;

import java.util.Arrays;

/**
 * Created by webse on 10/6/2016.
 */
public class MergeSort {
    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[]{5, 4, 3, 1, 2, -1, 0, -6, -7, -5};
        mergeSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
        int[] c = new int[]{1, 2, 0, 4, 5, 7, -9};
        mergeSort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }

    private static void mergeSort(int[] array, final int i, final int j) {
        if (i < j) {
            int m = (i + j) >>> 1;
            mergeSort(array, i, m);
            mergeSort(array, m + 1, j);
            merge(array, i, m, j);
        }
    }

    private static void merge(int[] array, final int i, final int m, final int j) {
        int kk = i;
        int left[] = Arrays.copyOfRange(array, i, m + 1);
        int right[] = Arrays.copyOfRange(array, m + 1, j + 1);
        int leftK = 0, rightK = 0;
        for (; kk < j && leftK < left.length && rightK < right.length; kk++) {
            if (left[leftK] < right[rightK]) {
                array[kk] = left[leftK++];
            } else {
                array[kk] = right[rightK++];
            }
        }
        while (leftK < left.length && kk <= j) {
            array[kk++] = left[leftK++];
        }
        while (rightK < right.length && kk <= j) {
            array[kk++] = right[rightK++];
        }
    }
}
