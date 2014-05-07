package algoritms;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonachi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t;
		long res1, res2, res3,res4;
		int n = 25;
		t = System.nanoTime();
		System.out.println("res1=" + f(n, 0, 1));
		System.out.println(res1 = System.nanoTime() - t);
		t = System.nanoTime();
		System.out.println("res2=" + f2(n));
		System.out.println(res2 = System.nanoTime() - t);
		//System.out.println(res2 / res1);
		t = System.nanoTime();
		System.out.println("res3=" + f3(n));
		System.out.println(res3 = System.nanoTime() - t);
		t = System.nanoTime();
		System.out.println("res4=" + f4(n));
		System.out.println(res4 = System.nanoTime() - t);
		t = System.nanoTime();
		System.out.println("res5=" + f5(n));
		System.out.println(System.nanoTime() - t);

	}

	public static long f(int n, long curVal1, long curVal2) {
		if (n == 1) {
			return 1;
		}
		return curVal1 + f(--n, curVal2, curVal1 + curVal2);
	}
	
	public static long f5(int n){
		long cur1=0;
		long cur2=1;
		for(int i=0;i<n;i++){
			long temp=cur1;
			cur1=cur2;
			cur2 = cur2 + temp;
		}
		return cur1;
	}

	public static long f2(long n) {
		if (n <= 1)
			return n;
		return f2(n - 1) + f2(n - 2);
	}

	public static int f3(int n) {
		int prev1 = 0, prev2 = 1;
		for (int i = 0; i < n; i++) {
			int savePrev1 = prev1;
			prev1 = prev2;
			prev2 = savePrev1 + prev2;
		}
		return prev1;
	}

	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	static {
		fibCache.add(BigInteger.ZERO);
		fibCache.add(BigInteger.ONE);
	}

	public static BigInteger f4(int n) {
		if (n >= fibCache.size()) {
			fibCache.add(n, f4(n - 1).add(f4(n - 2)));
		}
		return fibCache.get(n);
	}
}
