package collections.wildCards;

import java.util.ArrayList;
import java.util.List;

public class SuperWildCard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List l = new ArrayList<Number>();
		String s;
	}
	static void addSuper(List<? super Integer> l){
		//l.add(new Byte(1));
	}
	static void addExtends(List<? extends Integer> l){
		l.remove(1);
	}

}
