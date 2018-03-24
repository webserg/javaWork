package webserg.pazzlers.ch5;

/**
 * @author Sergiy Doroshenko
 */
public class Loop {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] tests = {{6, 5, 4, 3, 2, 1}, {1, 2}, {1, 2, 3},
                {1, 2, 3, 4}, {1}};
        int successCount = 0;
        for (int[] test : tests) {
            if (thirdElementIsThree(test))
                successCount++;
        }
        System.out.println(successCount);
    }

    private static boolean thirdElementIsThree(int[] a) {
        return a.length >= 3 && a[2] == 3;
    }
}
