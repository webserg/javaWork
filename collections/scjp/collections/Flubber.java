package collections.scjp.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Flubber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> x = new ArrayList<String>();
		x.add(" x"); x.add("xx"); x.add("Xx");
		Comparator c = Collections.reverseOrder();
		Collections.sort(x,c);
		for (String s : x) {
			System.out.println(s);
		}
		
	}

}
