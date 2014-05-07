package thread.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MILLISECOND, 1);
		System.out.println(new Date());
		new Timer().schedule(new TestTimer().new FTask(), c.getTime());
		

	}

	private class FTask extends TimerTask {

		@Override
		public void run() {
			System.out.println("qwerty");
			System.out.println(new Date());
		}

	}
}
