package webserg.pazzlers.ch9;

import java.util.Timer;
import java.util.TimerTask;

public class Worker extends Thread{
	private volatile boolean quittingTime = false;
	final private Object lock = new Object();
	
	public void run(){
		while(!quittingTime)
			pretendToWork();
		System.out.println("Beer is Good");
	}
	private void pretendToWork() {
		System.out.println("work");
		try {
			Thread.sleep(300);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void quit() throws InterruptedException{
		synchronized (lock) {
			quittingTime = true;
			System.out.println("quit");
			join();//waits for the workers thread to complete
		}	
		
		
	}
	void keepWorking(){
		synchronized (lock) {
			quittingTime = false;
			System.out.println("keep working");
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		final Worker worker  = new Worker();
		worker.start();
		
		Timer t = new Timer(true);
		t.schedule(new TimerTask(){
			@Override
			public void run() {
				System.out.println("deamon");
				worker.keepWorking();
			}
		}, 500);
	Thread.sleep(400);
	worker.quit();
	System.out.println("finish");	
	}
}
