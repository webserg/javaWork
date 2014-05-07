package webserg.pazzlers.ch5;

public class Strange1 {
	public static void main(String[] args) {

		try {

			Missing m = new Missing();

		} catch (java.lang.NoClassDefFoundError ex) {

			System.out.println("Got it!");

		}
		System.out.println("go...");

	}

}
