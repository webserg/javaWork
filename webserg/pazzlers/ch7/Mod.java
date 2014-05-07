package webserg.pazzlers.ch7;

public class Mod {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int MODULUS = 3;
		int[] histogram = new int[MODULUS];
		int i = Integer.MIN_VALUE; // pow(-2, 31)
		int k = Integer.MAX_VALUE;
		// System.out.println(i+3);
		System.out.println(i);
		do {
			// System.out.println(Math.abs(i));
			/**
			 * Note that if the argument is equal to the value of
			 * Integer.MIN_VALUE, the most negative representable int value, the
			 * result is that same value, which is negative.
			 */
			// histogram[Math.abs(i) % MODULUS]++;
			// histogram[mod(i,MODULUS)]++;
		} while (i++ != Integer.MAX_VALUE);
		for (int j = 0; j < MODULUS; j++) {
			System.out.println(histogram[j] + " ");
		}
		// System.out.println((Math.abs(Integer.MIN_VALUE) + Integer.MAX_VALUE)
		// / 3);
	}

	private static int mod(int i, int modulus) {
		int result = i % modulus;
		return result < 0 ? result + modulus : result;
	}
}
