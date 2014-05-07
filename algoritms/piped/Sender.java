package algoritms.piped;

import java.io.PipedWriter;

public class Sender extends Thread {
	private PipedWriter out = new PipedWriter();
	private static int finish = 1;
	public PipedWriter getPipedWriter() {
		return out;
	}

	public void run() {
		while (true) {
			for (char c = 'A'; c <= 'z'; c++) {
				try {
					finish++;
					out.write(c);
					if(finish == 400) System.exit(0);
					sleep(200);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
}
