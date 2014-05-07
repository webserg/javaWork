package webserg.pazzlers.ch7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class OneLiners {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("spam");
		s.add("sausage");
		s.add("spam");
		s.add("bacon");
		s.add("spam");
		s.add("tomato");
		s.add("spam");
		System.out.println(removeDuplicates(s));
		for (String r : splitCommas("fear, surprise, ruthless efficiency, an almost fanatical devotion to the Pope, nice red uniforms")) {
			System.out.println("\"" + r + "\"");
		}
		System.out.println(Arrays.asList(splitCommas("fear, surprise, ruthless efficiency, an almost fanatical devotion to the Pope, nice red uniforms")).toString());
		String[][][] ss  = {{{"dfsd","sdfsd"},{"sdf","sdfs"}}};
		System.out.println(Arrays.deepToString(ss));
		Class clazz = ss.getClass();
		if(clazz.isArray());
		/*for (String[][] t : ss) {
			System.out.println(t.length);
			for (String string : t) {
				System.out.println(string);
			}
		}*/
		System.out.println("------------------------");
		print1(ss);
	}

	static <E> List<E> removeDuplicates(final List<E> original) {
		
		return new ArrayList<E>(new HashSet<E>(original));
	}
	
	static String[] splitCommas(final String s){
		return s.split(",[\\s]*");
	}
	
	
	static <E> void print1(E o){
		List<E> l = Arrays.asList(o);
		for (E e : l) {
			System.out.println(e);
		}
	}
	
}
