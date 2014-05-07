package collections.maps;

import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapUsing {

    /**
     * @param args
     */
    public static void main(String[] args) {
	    TreeMap<String, String> t = new TreeMap<String, String>();
	    t.put("1", "1");
	    t.put("2", "2");
	    t.put("3", "3");
	    t.put("4", "4");
        for (String key : t.keySet()){
            if(key == "3") t.remove(key);
        }
       // if (it.next().equalsIgnoreCase("I"))
       //     it.remove();
    }

}
