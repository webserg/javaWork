package algoritms.sort.mergeSort;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Sergiy Doroshenko
 */
public class MergeSortAdvance extends TestCase {

    private static int[] source;

    private static void split(final int first, final int last) {
        if (first < last) {
            int middle = (first + last) >>> 1;
            split(first, middle);
            if (middle + 1 < last) split(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }

    /**
     * merge (leftFirst, leftLast, rightFirst, rightLast)
     * (uses a local array, tempArray)
     * <p>
     * Set saveFirst to leftFirst // To know where to copy back
     * Set index to leftFirst
     * while more items in left half AND more items in right half
     * if values[leftFirst] < values[rightFirst]
     * Set tempArray[index] to values[leftFirst]
     * Increment leftFirst
     * else
     * Set tempArray[index] to values[rightFirst]
     * Increment rightFirst
     * Increment index
     * Copy any remaining items from left half to tempArray
     * Copy any remaining items from right half to tempArray
     * Copy the sorted elements from tempArray back into values
     *
     * @param firstLeft  f
     * @param lastLeft   f
     * @param firstRight f
     * @param lastRight  f
     */
    private static void merge(int firstLeft, int lastLeft, int firstRight, int lastRight) {
        int[] temp = new int[source.length];
        int index = firstLeft;
        int saveF = firstLeft;
        while (firstLeft <= lastLeft && firstRight <= lastRight) {
            if (source[firstLeft] < source[firstRight]) {
                temp[index] = source[firstLeft];
                firstLeft++;
            } else {
                temp[index] = source[firstRight];
                firstRight++;
            }
            index++;
        }
        while (firstLeft < lastLeft + 1) {
            temp[index] = source[firstLeft];
            firstLeft++;
            index++;
        }
        while (firstRight < lastRight + 1) {
            temp[index] = source[firstRight];
            firstRight++;
            index++;
        }
        for (index = saveF; index <= lastRight; index++) {
            source[index] = temp[index];
        }
    }

    public void testSort() {
        System.out.println("start");
        int result[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        // source = ShuffleArray.shuffle(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        source = new int[]{6, 7, 4, 8, 5, 2, 1, 3};
        System.out.println(Arrays.toString(source));
        assertFalse(Arrays.equals(result, source));
        mergeSort(source);
        System.out.println(Arrays.toString(source));
        assertTrue(Arrays.equals(result, source));
    }

    /**
     * @param s s
     */
    public void mergeSort(int[] s) {
        source = s;
        if (source.length < 2)
            return;
        split(0, s.length - 1);

    }

    public void mergeSortStanford(int[] s) {
        source = s;
        if (source.length < 2)
            return;

    }
}
