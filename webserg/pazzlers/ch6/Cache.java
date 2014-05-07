package webserg.pazzlers.ch6;
/**
 * @author Sergiy Doroshenko
 * Use either eager or lazy initialization never both
 */
public class Cache {
	
	static {
		initializeIfNecessary();
	}

	private static int sum;
	public static int getSum() {
		initializeIfNecessary();
		return sum;
	}
	private static boolean initialized = false;//static fields must appears before any initializers that depend on it
	private static synchronized void initializeIfNecessary() {
		if (!initialized) {
			for (int i = 0; i < 100; i++)
				sum += i;
			initialized = true;
		}
	}
}
