package collections.maps;

import java.util.LinkedHashMap;

public class LinkedHashMapTest<KK, VV> {
	private LinkedHashMap<KK, VV> lhm = new LinkedHashMap<KK, VV>();
	
	void makeLinkedHashMap(KK k,VV v){
		lhm.put(k, v);
	}
	/**
	 * @param args
	 */
	public static <K,V> void main(String[] args) {
		LinkedHashMap<K, V> lhm = new LinkedHashMap<K, V>();
		new LinkedHashMapTest<String,String>().makeLinkedHashMap("first", "first");
		new LinkedHashMapTest<Integer,Integer>().makeLinkedHashMap(1, 2);
	}
}
