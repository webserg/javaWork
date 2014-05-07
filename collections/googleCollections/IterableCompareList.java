package collections.googleCollections;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: Sergiy Doroshenko
 * Date: Feb 2, 2010
 * Time: 5:08:10 PM
 */
public class IterableCompareList {
    public static void main(String[] argv) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        list1.add(Integer.valueOf(1));
        list1.add(Integer.valueOf(2));
        list1.add(Integer.valueOf(3));

        list2.add(Integer.valueOf(1));
        list2.add(Integer.valueOf(2));
        list2.add(Integer.valueOf(3));

//        boolean isEqual = Iterables.elementsEqual(list1, list2);
//        System.out.println(isEqual);
    }
}
