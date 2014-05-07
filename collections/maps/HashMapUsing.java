package collections.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The iterators returned by all of this class's "collection view methods" are fail-fast: if the map is structurally
 * modified at any time after the iterator is created, in any way except through the iterator's own remove or add
 * methods, the iterator will throw a ConcurrentModificationException. Thus, in the face of concurrent modification,
 * the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.
 * <p/>
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking, impossible to make
 * any hard guarantees in the presence of unsynchronized concurrent modification.
 * Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. Therefore,
 * it would be wrong to write a program that depended on this exception for its correctness: the fail-fast
 * behavior of iterators should be used only to detect bugs.
 */
public class HashMapUsing {
    public static void main(String[] args) {

        Map<String, String> m = new ConcurrentHashMap<>();
        m.put("1", "2");
        m.put("2", "2");
        m.put("3", "3");
        m.put("4", "4");
        for (Map.Entry<String, String> e : m.entrySet()) {
            System.out.println(e);
            m.remove(e.getKey());
        }
        System.out.println("===");
        m.put("5", "4");
        for (Map.Entry<String, String> e : m.entrySet()) {
            System.out.println(e);

        }
        Map f = freg(new String[]{"I", "love", "you", "you", "bu"});
        System.out.println(f.size() + " distinct words:");
        printMap(new HashMap(f));

        // Filter a map based on some property of its keys.
        for (Iterator<String> it = f.keySet().iterator(); it.hasNext(); )
            if (it.next().equalsIgnoreCase("I"))
                it.remove();

        System.out.println(f);
        Map synMap = freg(new String[]{"I", "love", "you", "you", "bu"});
        Map<String, String> sMap = Collections.synchronizedMap(synMap);

    }

    // The frequency table maps each word to the number of times it occurs in the argument list.
    public static Map freg(String[] input) {
        Map<String, Integer> m = new HashMap<>();
        for (String a : input) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }
        return m;
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
}

