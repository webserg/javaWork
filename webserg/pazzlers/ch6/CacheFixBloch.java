package webserg.pazzlers.ch6;

/**
 * @author Sergiy Doroshenko
 * Use eager initialization unless you have some good reason to use lazy initialization
 */
public class CacheFixBloch {
    private static final int sum = computeSum();

    private static int computeSum() {
        int result = 0;
        for (int i = 0; i < 100; i++) {
            result += 1;
        }
        return result;
    }

    /**
     * @return sum result of computation
     */
    public static int getSum() {
        return sum;
    }
}
