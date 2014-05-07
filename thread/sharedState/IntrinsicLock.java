package thread.sharedState;

import java.math.BigInteger;

public class IntrinsicLock implements FibonacciGenerator<BigInteger> {

    private BigInteger curr = BigInteger.ONE;
    private BigInteger next = BigInteger.ONE;

    @Override
    public synchronized BigInteger next() {
        BigInteger result = curr;
        curr = next;
        next = result.add(next);
        return result;
    }

    @Override
    public synchronized BigInteger val() {
        return curr;
    }

}
