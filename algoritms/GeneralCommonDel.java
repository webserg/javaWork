package algoritms;

public class GeneralCommonDel {
    public static long gcd(long i, long j) {
        if (j == 0) return i;
        return gcd(j, i % j);
    }

    public static long gcd2(long i, long j) {
        long t;
        while (i != 0) {
            if (j >= i)
                j -= i;
            else {
                t = i;
                i = j;
                j = t;
            }
        }
        return j;
    }

    public static void main(String[] argv) {
        int m = 544;
        int n = 119;

        System.out.println("n = " + gcd2(n, m));
        System.out.println("n = " + gcd2(8, 3));
        System.out.println("n = " + gcd2(123, 28));
        System.out.println("n = " + gcd(123, 28));
        System.out.println("n = " + gcd2(187, 77));
        System.out.println("n = " + gcd2(105, 385));
        System.out.println("n = " + gcd(105, 385));
        System.out.println("n = " + gcd2(245, 193));
        System.out.println("n = " + gcd(245, 193));
        assert gcd2(123, 28) == 1 : "check gcd";
        assert gcd(123, 28) == 1 : "check gcd";

    }
}
