package patterns.headFirstDesignPatterns.singleton.threadsafe;

/**
 * works fine for multithreaded access to the getInstance() method.
 * However, when you analyze it you realize that synchronization is
 * required only for the first invocation of the method. Subsequent
 * invocations do not require synchronization because the first invocation is
 * the only invocation that executes the code at //2, which is the only line that
 * requires synchronization. All other invocations determine that instance is non-null
 * and return it. Multiple threads can safely execute concurrently on all invocations except
 * the first. However, because the method is synchronized, you pay the cost of synchronization
 * for every invocation of the method, even though it is only required on the first invocation.
 */
public class Singleton {
	private static Singleton uniqueInstance;
 
	// other useful instance variables here
 
	private Singleton() {}
 
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
}
