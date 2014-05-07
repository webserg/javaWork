package thread.scjp.threads;

public class PriorityThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable(){
			public void run(){
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + i);
				}
			}
		},"a");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + i);
					if(i==50) Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
				}
			}
		},"b");
		System.out.println("Thread.MAX_PRIORITY " + Thread.MAX_PRIORITY);
		System.out.println("Thread.MIN_PRIORITY " + Thread.MIN_PRIORITY);
		System.out.println("Thread.NORM_PRIORITY " + Thread.NORM_PRIORITY);
		
	
		System.out.println("t2.getPriority()" + t2.getPriority());
		//t2.setPriority(Thread.MAX_PRIORITY);
		
		t.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName() + " has proirity " + Thread.currentThread().getPriority());
		System.out.println("t2.getPriority()" + t2.getPriority());
		while(true) {if(!t2.isAlive()) { System.out.println("t2.getPriority()" + t2.getPriority());break;}}
	}

}
