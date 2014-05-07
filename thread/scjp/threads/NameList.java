package thread.scjp.threads;

import java.util.ArrayList;
import java.util.List;

public class NameList {
	private List names = new ArrayList();

	public synchronized void add(String name) {
		names.add(name);
	}

	public synchronized void printAll() {
		System.out.println("printing " + Thread.currentThread().getName());
		for (int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i) + " ");
		}
	}

	public static void main(String[] args) {
		final NameList sl = new NameList();
		for (int i = 0; i < 2; i++) {
			new Thread("" + i) {
				public void run() {
					sl.add("A" + Thread.currentThread().getName());
					sl.add("B" + Thread.currentThread().getName());
					sl.add("C" + Thread.currentThread().getName());
					sl.printAll();
				}
			}.start();
		}
	}
}

// Options given

// A. An exception may be thrown at runtime.
// B. The code may run with no output, without exiting.
// C. The code may run with no output, exiting normally.
// D. The code may rum with output �A B A B C C �, then exit.
// E. The code may rum with output �A B C A B C A B C �, then exit.
// F. The code may ruin with output �A A A B C A B C C �, then exit.
// G. The code may ruin with output �A B C A A B C A B C �, then exit.
