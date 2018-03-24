package collections.scjp.collections;

import java.util.HashMap;

public class AutoBoxCollection {

    /**
     * @param args
     */
    public static void main(String[] args) {
        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        map.put(1, 1.0);
        map.put(new Integer(1), new Double(2.0));
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
            System.out.println(key = key + 1);
        }
    }
}
