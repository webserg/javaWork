package thread.concurrencyInPractice;

public class NoVisibility {
    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {
	public void run() {
	    while (!ready)
		Thread.yield();
	    System.out.println(number);
	}
    }

    public static void main(String[] args) {
	new ReaderThread().start();
	number = 42;
	try {
	    Thread.sleep(10000);
	} catch (InterruptedException e) {
	    
	    e.printStackTrace();
	}
	/*
	 * ready may be visible to the reader thread before to write the number
	 * it's specific of working JVM(reordering phenomenon) like READ_UNCOMITTED isolation
	 * level in database
	 * */
	ready = true;
    }
}
