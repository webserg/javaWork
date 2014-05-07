package webserg.pazzlers.ch9;

public class PingPong {

	/**
	 * @param args
	 */
	public static  synchronized void main(String[] args) {
		Thread t  = new Thread(){
			public void run(){pong();}
		};
		t.run();
		System.out.println("Ping");
	}

	synchronized static void pong() {
		System.out.println("Pong");
	}

}
