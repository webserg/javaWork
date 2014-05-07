package thread.scjp.threads;

public class Reader extends Thread{
	Calculator c ;
	public Reader(Calculator calc,String name) {
		super(name);
		c = calc;
		System.out.println(this.getClass().getName());
	}
	public void run(){
		synchronized (c) {
			System.out.println("waiting...");
			while(c.total < 704982704)
			try {
				
				c.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " + c.total);
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Calculator calc = new Calculator();
		new Reader(calc,"1"){}.start();
		calc.start();
		new Reader(calc,"2").start();
		new Reader(calc,"3").start();
		
		
		
	}

}
class Calculator extends Thread{
	int total;
	public void run(){
		synchronized (this) {
			notifyAll();
			for (int i = 0; i < 100000; i++) {
				total+=i;
				
			}
			/*try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
} 