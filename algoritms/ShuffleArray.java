package algoritms;

import junit.framework.Assert;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] k = {0, 1, 2, 3, 4, 5, 6, 7};
        int res[] = ShuffleArray.shuffle(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 125});
        System.out.println(Arrays.toString(res));
        Assert.assertNotSame(k, res);
        res = ShuffleArray.shuffleKnuth(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 125});
        System.out.println(Arrays.toString(res));
        Assert.assertNotSame(k, res);
    }

    public static int[] shuffle(int[] source) {
        int l = source.length;
        int[] target = new int[l];
        int k;
        for (int i = 0; i < target.length; i++) {
            double kk = Math.random();
            k = (int) (kk * l--);
            target[i] = source[k];
            source[k] = source[l];
        }
        return target;
    }

    public static int[] shuffleKnuth(int[] source) {
        int l = source.length;
        int k;
        Random randomGen = new Random();
        for (int i = 0; i < l; i++) {
            k = randomGen.nextInt(i + 1);
//            System.out.println(k);
            swap(source, i, k);
        }
        return source;
    }

    private static void swap(int[] source, int i, int k) {
        int tmp = source[i];
        source[i] = source[k];
        source[k] = tmp;
    }

}
