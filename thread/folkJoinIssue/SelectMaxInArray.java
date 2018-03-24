package thread.folkJoinIssue;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * // PSEUDOCODE
 * Result solve(Problem problem) {
 * if (problem.size < SEQUENTIAL_THRESHOLD)
 * return solveSequentially(problem);
 * else {
 * Result left, right;
 * INVOKE-IN-PARALLEL {
 * left = solve(extractLeftHalf(problem));
 * right = solve(extractRightHalf(problem));
 * }
 * return combine(left, right);
 * }
 * }
 * The first thing a parallel divide-and-conquer
 * algorithm does is evaluate whether the problem
 * is so small that a sequential solution would
 * be faster; typically, this is done by comparing
 * the problem size to some threshold.
 * If the problem is large enough to merit parallel decomposition,
 * it divides the problem into two or more sub-problems and
 * recursively invokes itself on the sub-problems in parallel,
 * waits for the results of the sub-problems,
 * and then combines the results.
 *
 * @author Sergiy Doroshenko webserg@gmail.com
 * May 26, 2009 11:30:09 AM
 */
public class SelectMaxInArray extends RecursiveAction {

    private final Issue issue;
    public int result;

    public SelectMaxInArray(Issue issue) {
        this.issue = issue;
    }

    public static void main(String[] args) {
        Issue test = new Issue(Issue.getInitIssue());
        Issue test2 = new Issue(Issue.getInitIssue());
        // Check the number of available processors
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
        SelectMaxInArray t = new SelectMaxInArray(test);
        ForkJoinPool pool = new ForkJoinPool(nThreads);
        Long start = System.nanoTime();
        pool.invoke(t);
        Long end = System.nanoTime();
        long result = t.result;
        System.out.println("Done. Result: " + result + "time1 : " + (end - start));
        Long start2 = System.nanoTime();
        long result2 = test2.solveSequentially();
        Long end2 = System.nanoTime();
        System.out.println("Done. Result: " + result2 + "time2 : " + (end2 - start2));
    }

    @Override
    protected void compute() {
        if (issue.getSize() <= 1000000000) {
            result = issue.solveSequentially();
        } else {

            int midpoint = issue.getSize() / 2;
            SelectMaxInArray s1 = new SelectMaxInArray(issue.subproblem(0, midpoint));
            SelectMaxInArray s2 = new SelectMaxInArray(issue.subproblem(midpoint + 1, issue.getSize()));
            invokeAll(s1, s2);
            result = Math.max(s1.result, s2.result);
        }

    }

}
