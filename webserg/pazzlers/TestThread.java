package webserg.pazzlers;

import junit.framework.TestCase;

public class TestThread extends TestCase {
    int number;

    public void test() throws InterruptedException {
	number = 0;
	Thread t = new Thread(new Runnable() {
	    public void run() {
		assertEquals(32, number);
	    }
	});
	number = 1;
	t.start();
	number ++;
	t.join();
    }
}
