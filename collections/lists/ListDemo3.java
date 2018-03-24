package collections.lists;

import java.util.*;

public class ListDemo3 {
    static final int N = 500000;

    // Lists of keys and values

    static List keys;

    static List values;

    // fill the keys list with ascending order key
    // values and fill the values list with
    // corresponding values (-key)
    static Map map = new HashMap();

    // fill a Map with key/value pairs

    static {
        Integer keyvec[] = new Integer[N];
        Integer valuevec[] = new Integer[N];

        Random rn = new Random();

        for (int i = 0, currval = 0; i < N; i++) {
            keyvec[i] = currval;
            valuevec[i] = -currval;
            currval += rn.nextInt(100) + 1;
        }

        keys = Arrays.asList(keyvec);
        values = Arrays.asList(valuevec);
    }

    static {
        for (int i = 0; i < N; i++) {
            map.put(keys.get(i), values.get(i));
        }
    }

    // do binary search lookup of all keys

    static long timeList() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            int indx = Collections.binarySearch(keys, keys.get(i));

            // sanity check of returned value
            // from binary search

            if (indx != i) {
                System.out.println("*** error ***\n");
            }
        }

        return System.currentTimeMillis() - start;
    }

    // do Map lookup of all keys

    static long timeMap() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            Integer value = (Integer) map.get(keys.get(i));

            // sanity check of value returned
            // from map lookup

            if (value != values.get(i)) {
                System.out.println("*** error ***\n");
            }
        }

        return System.currentTimeMillis() - start;
    }

    public static void main(String args[]) {

        // do timing for List implementation

        System.out.println("List time = " + timeList());

        // do timing for Map implementation

        System.out.println("Map time = " + timeMap());
    }
}
