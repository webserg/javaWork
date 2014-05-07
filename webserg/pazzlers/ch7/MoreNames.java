package webserg.pazzlers.ch7;

import java.util.HashMap;
import java.util.Map;

public class MoreNames {
	private Map<String,String> m = new HashMap<String, String>();
	
	/**
	 * Don't use method with the same name as the class 
	 */
	public void MoreNames() {
		m.put("Mickey", "Mouse");
		m.put("Mickey", "Mantle");
	}
	public int size() {
		return m.size();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args){
		MoreNames m  = new MoreNames();
		System.out.println(m.size());
	}

}
