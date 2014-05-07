package collections.scjp.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Before {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Integer i;
		Set set = new TreeSet();
		//set.add("2");
		//set.add(1);
		int[] i = {1,2,3,4,5};
		i[0]=2;
		List l =Arrays.asList(i);
		System.out.println(Arrays.toString(i));
		int k=0;
		System.out.println(((int[])l.get(0))[0]);
		System.out.print("[");
		for (Object o : l) {
			if(k != 0) {System.out.print(",");k++;}
			System.out.print(o);
		}
		System.out.println("]");

	}

}
