package collections.maps;

import java.util.HashMap;
import java.util.Map;

public class CopyMap {

    /**
     * @param args
     */
    public static <K, V> void main(String[] args) {

        Map<String, Integer> source = new HashMap<String, Integer>();
        source.put("1", 1);
        source.put("2", 2);
        source.put("3", 3);
        source.put("4", 4);

        System.out.println(copy(source));

    }

    static <K, V> Map<K, V> copy(Map<K, V> m) {
        V[] k;
        return new HashMap<K, V>(m);
    }
}
