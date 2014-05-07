package collections.maps;

import java.util.HashMap;
import java.util.Map;

public class MapEQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<ToDos,String> m = new HashMap<ToDos, String>();
		ToDos t1 = new ToDos("M");
		ToDos t2 = new ToDos("M");
		ToDos t3 = new ToDos("T");
		m.put(t1,"aa" );
		m.put(t2,"bb" );
		m.put(t3,"cc" );
		System.out.println(m.size());
		System.out.println(""=="");
	}

}
class ToDos extends Object{
	String day;
	ToDos(String d){day = d;}
	public boolean equals(Object o){
		return ((ToDos) o).day == this.day;
	}
	public int hashCode(){return 9;}
}