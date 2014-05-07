package thread.ch03;

public class PrintAllThread {
	public void printThreads() {
		Thread ta[] = new Thread[Thread.activeCount()];
		int n = Thread.enumerate(ta);
		for (int i = 0; i < n; i++) {
			System.out.println("Thread " + i + " is " + ta[i].getName());
		}
	}

	public static void main(String[] argv) {
		PrintAllThread p = new PrintAllThread();
		System.out.println("---");
		p.printThreads();
	}
}
