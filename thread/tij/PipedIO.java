package thread.tij;

import java.util.Timer;
import java.util.TimerTask;
public class PipedIO {
	public static void main(String[] args) throws Exception {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		sender.start();
		receiver.start();
		new Timer(true).schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("exit");
				System.exit(0);
			}
			
		}, 50000);
		}
}
