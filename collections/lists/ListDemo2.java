package collections.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo2 {
    static final int N = 50000;

    // time how long it takes to add
    // N objects to a list

    static long timeList(List lst) {
        long start = System.currentTimeMillis();

        Object obj = new Object();

        for (int i = 0; i < N; i++) {
            lst.add(0, obj);
        }

        return System.currentTimeMillis() - start;
    }

    public static void main(String args[]) {

        // do timing for ArrayList

        System.out.println("time for ArrayList = " + timeList(new ArrayList()));

        // do timing for LinkedList

        System.out.println("time for LinkedList = "
                + timeList(new LinkedList()));
    }
}