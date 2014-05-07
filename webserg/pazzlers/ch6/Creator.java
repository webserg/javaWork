package webserg.pazzlers.ch6;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Sergiy Doroshenko
 */
public class Creator {
	Integer flag = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Creator cr = new Creator();
		Thread t1 = new Thread() {
			@Override
			public void run() {

				// Creator cr = new Creator();
				cr.createCount();
				synchronized (cr) {
					cr.flag++;
					cr.notify();
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				// Creator cr = new Creator();
				cr.createCount();
				synchronized (cr) {
					cr.flag++;
					cr.notify();
				}
			}
		};

		t1.start();
		t2.start();
		synchronized (cr) {
				while (cr.flag < 2) {
					try {
						cr.wait();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
			System.out.println(Creature.getNumCreated());
		
	}

	/**
	 * 
	 */
	private void createCount() {
		for (int i = 0; i < 100; i++)
			new Creature();
			
	}
}

class Creature {
	private static AtomicLong numCreated = new AtomicLong();

	public Creature() {
		numCreated.incrementAndGet();
	}

	public static long getNumCreated() {
		return numCreated.get();
	}
}