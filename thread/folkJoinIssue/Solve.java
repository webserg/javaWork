package thread.folkJoinIssue;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;


public class Solve extends RecursiveAction {
    public long result;
    private int[] list;

    public Solve(int[] array) {
        this.list = array;
    }

    @Override
    protected void compute() {
        if (list.length == 1) {
            result = list[0];
        } else {
            int midpoint = list.length / 2;
            int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
            int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
            Solve s1 = new Solve(l1);
            Solve s2 = new Solve(l2);
            invokeAll(s1, s2);
            result = s1.result + s2.result;
        }
    }
}


