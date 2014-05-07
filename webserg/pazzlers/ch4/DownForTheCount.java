package webserg.pazzlers.ch4;

public class DownForTheCount {
	public static void main(String[] args) {
		final int START = 2000000000;
		//                2147483647	
		int count = 0;
		float f = START;
		System.out.println(f++);
		for (; f < START + 50; f++) {
			count++;
		}
		System.out.println(count);
	}
}
