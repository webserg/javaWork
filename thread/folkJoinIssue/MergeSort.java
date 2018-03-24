package thread.folkJoinIssue;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class MergeSort extends RecursiveAction {
    public static final int SEQUENTIAL_THRESHOLD = 100;
    final int[] numbers;
    final int startPos, endPos;
    private int[] result;

    public MergeSort(int[] n, int str, int end) {
        numbers = n;
        startPos = str;
        endPos = end;
        result = new int[n.length];
    }

    public static void main(String[] args) {
        Issue test = new Issue(Issue.getInitIssue());
        Issue test2 = new Issue(Issue.getInitIssue());
        // Check the number of available processors
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
        int[] arr1 = Issue.getInitIssue();
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length - 1);
        MergeSort t = new MergeSort(Issue.getInitIssue(), 0, arr1.length - 1);
        ForkJoinPool pool = new ForkJoinPool(nThreads);
        Long start = System.nanoTime();
        pool.invoke(t);
        Long end = System.nanoTime();
        int[] result = t.getResult();
        System.out.println("Done. Result: time1 : " + (end - start));
        Long start2 = System.nanoTime();
        Arrays.sort(arr2, 0, arr1.length);
        Long end2 = System.nanoTime();
        System.out.println("Done. Result: time2 : " + (end2 - start2));
    }

    public int[] getResult() {
        return result;
    }

    private void merge(MergeSort left, MergeSort right) {
        int i = 0, leftPos = 0, rightPos = 0, leftSize = left.size(), rightSize = right.size();
        while (leftPos < leftSize && rightPos < rightSize)
            result[i++] = (left.result[leftPos] <= right.result[rightPos])
                    ? left.result[leftPos++]
                    : right.result[rightPos++];
        while (leftPos < leftSize)
            result[i++] = left.result[leftPos++];
        while (rightPos < rightSize)
            result[i++] = right.result[rightPos++];
    }

    public int size() {
        return endPos - startPos;
    }

    protected void compute() {
        if (size() < SEQUENTIAL_THRESHOLD) {
            System.arraycopy(numbers, startPos, result, 0, size());
            Arrays.sort(result, 0, size());
        } else {
            int midpoint = size() / 2;
            MergeSort left = new MergeSort(numbers, startPos, startPos + midpoint);
            MergeSort right = new MergeSort(numbers, startPos + midpoint, endPos);
            invokeAll(left, right);
            merge(left, right);
        }
    }
}

