package thread.scjp.threads;

public class StaticSynch {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException{
		Thread t = new Thread();
		t.start();
		System.out.print("X");
		synchronized (t) {
			t.wait(100000000);
		}	
		
		System.out.print("Y");
	}
}
