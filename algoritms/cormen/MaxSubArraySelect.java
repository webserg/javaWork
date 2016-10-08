package algoritms.cormen;

/**
 * Created by webse on 10/7/2016.
 * Cormen s 89
 */
public class MaxSubArraySelect {
    public static void main(String[] args) {
        int[] array = new int[]{0, 13, -3, -25 , -20, -3, -16, /*7*/-23, 18, 20, /*10*/-7, 12, -5, -22, 15, -4, 7};

        int maxSum = 0;
        int i = 0;
        int j = 0;

        for (int ii = 6; ii < array.length; ii++) {
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



        System.out.println("sum = " + maxSum + "; buy day =" + i + "; sell day =" + j);

    }
}
