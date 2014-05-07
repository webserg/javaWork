package thread.scjp.threads;

public class ThreadException implements Runnable{

	public void run(){
		System.out.println("run");
		throw new RuntimeException();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new ThreadException()).start();
		System.out.println("end");
	}

}
