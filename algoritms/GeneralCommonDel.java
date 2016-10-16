package algoritms;

public class GeneralCommonDel {
    public static long gcd(long i, long j) {
        if (j == 0) return i;
        return gcd(j, i % j);
    }

    public static long gcd5(long i, long j) {
        if (j == 0) return i;
        return gcd5(j, mod(i, j));
    }

    public static long mod(long i, long j) {
        while (i >= j) i -= j;
        return i;
    }

    public static long gcd3(long i, long j) {
        if (j == 0) return i;
        if (i >= j) {
            return gcd3(j, i - j);
        } else {
            return gcd3(i, j - i);
        }
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

    public static long gcd4(long i, long j) {
        if (i == 0) return j;
        while (i != 0) {
            if (i >= j)
                i -= j;
            else {
                j -= i;
            }
        }
        return i;
    }

    public static void main(String[] argv) {
        int m = 544;
        int n = 119;

        System.out.println("n = " + gcd2(n, m));
        System.out.println("n = " + gcd2(8, 3));
//        System.out.println("n = " + gcd5(8, 3));
        System.out.println("n = " + gcd2(3, 8));
        System.out.println("n = " + gcd4(8, 3));
        System.out.println("n = " + gcd3(8, 3));
        System.out.println("n = " + gcd2(123, 28));
        System.out.println("n = " + gcd(123, 28));
        System.out.println("n = " + gcd2(187, 77));
        System.out.println("n = " + gcd2(105, 385));
        System.out.println("n = " + gcd(105, 385));
        System.out.println("n = " + gcd2(245, 193));
        System.out.println("n = " + gcd(245, 193));
        assert gcd2(123, 28) == 1 : "check gcd";
        assert gcd(123, 28) == 1 : "check gcd";
        assert gcd3(123, 28) == 1 : "check gcd";
        assert gcd3(245, 193) == 1 : "check";
        assert gcd3(385, 105) == 35 : "check";
        assert gcd(385, 105) == 35 : "check";
        assert gcd5(385, 105) == 35 : "check";
        assert gcd2(385, 105) == 35 : "check";

    }
}
