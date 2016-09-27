package algoritms.random;

import java.util.Random;
import java.util.stream.IntStream;

public class Gen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r  =  new Random();
		IntStream intStream = new Random().ints();
		Math.random();
		for (int i = 0; i < 6; i++) {
			
		
		System.out.println(r.nextInt(10));
		System.out.println(r.nextInt());
		}

	}

}
