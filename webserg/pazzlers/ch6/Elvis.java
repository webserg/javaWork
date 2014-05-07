package webserg.pazzlers.ch6;

import java.util.Calendar;
/**
 * to fix this class you must reorder the static field so that
 * each initializer appears before any initializers that depend on it
 * @author Sergiy Doroshenko
 *
 */
public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	public final int k; // it is possible to observe a final static field before it is initialized
	public static final int j = Test.get();
	
	private static final int CURRENT_YEAR =
		Calendar.getInstance().get(Calendar.YEAR);

	
	private final int beltSize;


	private Elvis() {
		k = 2 + j;
		beltSize = CURRENT_YEAR - 1930;
		
	}

	public int beltSize() {
		return beltSize;
	}

	public static void main(String[] args) {
		/*System.out.println("Elvis wears a size " +
		INSTANCE.beltSize() + " belt.");*/
		System.out.println(INSTANCE.k);
	}

}

class Test{
	static int get(){
		return 2;
	}
}
