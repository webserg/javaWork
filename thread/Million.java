package thread;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:42:08 PM
 */
public class Million {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		new Thread(new T(),"1").start();
	}


}

class T implements Runnable{
	public void run() {
		long i = Long.parseLong(Thread.currentThread().getName());
		System.out.println(i++);
		if(i<1000)
			new Thread(new thread.T(),"" + i).start();
	}
}