package algoritms;

import java.math.BigInteger;

public class FactorialBigInteger {
    public static void main(String[] args) {
        final int n = 20;
        BigInteger b = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            b = b.multiply(BigInteger.valueOf(i));
            System.out.println(i + "!" + "=" + b);
        }
        //System.out.println(FactorialScala.factorial(1));
    }
}
