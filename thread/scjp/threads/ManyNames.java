package thread.scjp.threads;

public class ManyNames {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NameRunnable r = new NameRunnable();
		Thread a = new Thread(r,"a");
		Thread b = new Thread(r,"b");
		Thread c = new Thread(r,"c");
		a.start();
		b.start();
		c.start();
		for (int i = 0; i < 200; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 100 ){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
