package thread.scjp.threads;

public class Letters extends Thread{
	private String name;
	public Letters(String name){
		this.name = name;
	}
	public void write(){
		System.out.print(name);
		System.out.print(name);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Letters("X").start();
		System.out.println("1");
		new Letters("Y").start();
		System.out.println("2");
	}
	public void run(){
		synchronized (System.out) {
			write();
		}
	}
}
