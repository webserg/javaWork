package algoritms.cormen;

/**
 * Created by webse on 10/7/2016.
 * Cormen s 89
 * <p>
 * Let’s think about how we might solve the maximum-subarray problem using
 * the divide-and-conquer technique. Suppose we want to find a maximum subarray
 * of the subarray AOElow : : high. Divide-and-conquer suggests that we divide
 * the subarray into two subarrays of as equal size as possible. That is, we find
 * the midpoint, say mid, of the subarray, and consider the subarrays AOElow : : mid
 * and AOEmid C 1 : : high. As Figure 4.4(a) shows, any contiguous subarray AOEi : : j
 * of AOElow : : high must lie in exactly one of the following places:
 * entirely in the subarray AOElow : : mid, so that low  i  j  mid,
 * entirely in the subarray AOEmid C 1 : : high, so that mid < i  j  high, or
 * crossing the midpoint, so that low  i  mid < j  high.
 * Therefore, a maximum subarray of AOElow : : high must lie in exactly one of these
 * places. In fact, a maximum subarray of AOElow : : high must have the greatest
 * sum over all subarrays entirely in AOElow : : mid, entirely in AOEmid C 1 : : high,
 * or crossing the midpoint. We can find maximum subarrays of AOElow : : mid and
 * AOEmidC1 : : high recursively, because these two subproblems are smaller instances
 * of the problem of finding a maximum subarray. Thus, all that is left to do is find a
 * maximum subarray that crosses the midpoint, and take a subarray with the largest
 * sum of the three.
 */
public class MaxSubArraySelect {
    public static void main(String[] args) {
        int[] array = new int[]{0, 13, -3, -25, -20, -3, -16, /*7*/-23, 18, 20, /*10*/-7, 12, -5, -22, 15, -4, 7};

        for (int idx = 0; idx < array.length; idx++) {
            System.out.println(idx + "   " + array[idx]);
        }

        int maxSum = 0;
        int i = 0;
        int j = 0;

        for (int ii = 6; ii < array.length; ii++) {//brute force
            int curSum = array[ii];
            for (int jj = ii + 1; jj < array.length; jj++) {
                curSum += array[jj];
                if (curSum > maxSum) {
                    maxSum = curSum;
                    i = ii;
                    j = jj;
                }
            }
        }

        System.out.println("sum = " + maxSum + "; i=" + i + "; j=" + j);

        maxSum = 0;
        for (int ii = array.length - 1; ii > 0; ii--) {//brute force
            int curSum = array[ii];
            for (int jj = ii - 1; jj > 0; jj--) {
                curSum += array[jj];
                if (curSum > maxSum) {
                    maxSum = curSum;
                    i = ii;
                    j = jj;
                }
            }
        }

        System.out.println("sum = " + maxSum + "; buy day =" + j + "; sell day =" + i);

        System.out.println(findMaxSubArray(array, 0, array.length - 1));

    }

    private static Res findMaxSubArray(int[] a, final int i, final int j) { // divide and conquer
        if (i == j) {
            return Res.res(i, j, a[i]);//base case one element
        }
        final int mid = (i + j) >>> 1;
        Res maxR;
        final Res rightR = findMaxSubArray(a, i, mid);
        maxR = rightR;
        final Res leftR = findMaxSubArray(a, mid + 1, j);
        maxR = leftR.sum > maxR.sum ? leftR : maxR;
        final Res crossingR = findMaxSubCrossingArray(a, i, mid, j);
        maxR = crossingR.sum > maxR.sum ? crossingR : maxR;
        return maxR;
    }

    private static Res findMaxSubCrossingArray(int[] a, final int low, final int mid, final int hight) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int curSum = 0;
        int maxI = 0;
        int maxJ = 0;

        for (int ii = mid; ii >= low; ii--) {
            curSum += a[ii];
            if (curSum > leftSum) {
                leftSum = curSum;
                maxI = ii;
            }
        }
        curSum = 0;
        for (int jj = mid + 1; jj <= hight; jj++) {
            curSum += a[jj];
            if (curSum > rightSum) {
                rightSum = curSum;
                maxJ = jj;

            }
        }
        return Res.res(maxI, maxJ, leftSum + rightSum);
    }


    private static class Res {
        int i;
        int j;
        int sum;

        Res() {
            i = 0;
            j = 0;
            sum = 0;
        }

        private Res(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }


        static Res res(int i, int j, int sum) {
            return new Res(i, j, sum);
        }

        @Override
        public String toString() {
            return "Res{" +
                    "i=" + i +
                    ", j=" + j +
                    ", sum=" + sum +
                    '}';
        }
    }
}
