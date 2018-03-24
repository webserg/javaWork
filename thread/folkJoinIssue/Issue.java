package thread.folkJoinIssue;

import java.util.Random;

/**
 * This class defines a long list of integers which defines the problem we will
 * later try to solve
 */

public class Issue {
    private final int start;
    private final int end;


    private final int[] list;


    public Issue(int[] l) {
        this.start = 0;
        this.end = l.length;
        list = l;
    }

    public Issue(int[] l, int start, int end) {
        this.start = start;
        this.end = end;
        list = l;
    }

    public static int[] getInitIssue() {
        int[] list = new int[Integer.MAX_VALUE / 1000];
        Random generator = new Random(195804);
        for (int i = 0; i < list.length; i++) {
            list[i] = generator.nextInt(500);
        }
        return list;
    }

    public Issue subproblem(int subStart, int subEnd) {
        return new Issue(list, start + subStart,
                start + subEnd);
    }

    public int getSize() {
        return end - start;
    }

    public int solveSequentially() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < end; i++) {
            int n = list[i];
            if (n > max)
                max = n;
        }
        return max;
    }

    public int[] getList() {
        return list;
    }

}
