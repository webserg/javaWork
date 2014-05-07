package webserg.pazzlers.ch4;
/**
 * 
 * @author Sergiy Doroshenko
 *
 */
public class Shift {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		int i = 0;
		//infinite loop
		while (-1 << i != 0) {// never will be 0 because shift -1 << 32 will be -1
			i++;
			System.out.println(i);
		}
		
	}

}
