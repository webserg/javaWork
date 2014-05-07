package collections.scjp.collections;

import java.util.HashMap;
import java.util.Set;

public class NumberNames {
	private HashMap<String,Integer> map = new HashMap<String, Integer>();
	public void put(String name , int value){
		map.put(name, value);
	}
	public Set getNames(){
		return map.keySet();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberNames nn = new NumberNames();
		nn.put("one", 1);
		System.out.println(nn.getNames());
	}

}
