package collections.lists;

import java.util.*;

public class ListDemo1 {
    static final int N = 10000;

    static List values;

    // make List of increasing Integer values

    static {
        Integer vals[] = new Integer[N];

        Random rn = new Random();

        for (int i = 0, currval = 0; i < N; i++) {
            vals[i] = new Integer(currval);
            currval += rn.nextInt(100) + 1;
        }

        values = Arrays.asList(vals);
    }

    // iterate across a list and look up every
    // value in the list using binary search

    static long timeList(List lst) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {

            // look up a value in the list
            // using binary search

            int indx = Collections.binarySearch(lst, values.get(i));

            // sanity check for result
            // of binary search

            if (indx != i) {
                System.out.println("*** error ***\n");
            }
        }

        return System.currentTimeMillis() - start;
    }

    public static void main(String args[]) {

        // do lookups in an ArrayList

        System.out.println("time for ArrayList = "
                + timeList(new ArrayList(values)));

        // do lookups in a LinkedList

        System.out.println("time for LinkedList = "
                + timeList(new LinkedList(values)));
    }
}
