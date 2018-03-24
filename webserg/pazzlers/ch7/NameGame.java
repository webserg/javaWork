package webserg.pazzlers.ch7;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author Sergiy Doroshenko
 */
public class NameGame {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> m = new IdentityHashMap<String, String>();
        //Map<String,String> m = new HashMap<String, String>();
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
        System.out.println(m.size());
        for (Map.Entry<String, String> e : m.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
