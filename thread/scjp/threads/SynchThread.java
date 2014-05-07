package thread.scjp.threads;

public class SynchThread extends Thread {
	StringBuffer str;

	public SynchThread(StringBuffer s) {
		this.str = s;
	}

	public void run() {
		synchronized (str) {
			System.out.println(Thread.currentThread().getName() + " is working ");
			for (int i = 0; i < 10000; i++) {
				System.out.print(str);
			}
			System.out.println();
			char c = (char)(str.charAt(0)+1);
			Character ch = new Character(c);
			
			str.deleteCharAt(0).append(c);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer("a");
		SynchThread synchThread = new SynchThread(buf);
		Thread t1 = new Thread(synchThread,"1");
		Thread t2 = new Thread(synchThread,"2");
		Thread t3 = new Thread(synchThread,"3");
		t1.start();
		t2.start();
		t3.start();
	}

}
