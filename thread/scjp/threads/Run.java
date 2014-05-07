package thread.scjp.threads;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				System.out.println("A");
			}
		}.start();
		
		new Thread(new Runnable(){
			public void run(){
				System.out.println("B");
			}
		}){
			public void run(){
				System.out.println("C");
			}
		}.start();
		
		new Thread(new Thread(){
			public void run(){
				System.out.println("D");
			}
		}){
			public void run(){
				System.out.println("F");
			}
		}.start();
		Runnable b  = new Thread(){};
		class My{}
		
	}

}
