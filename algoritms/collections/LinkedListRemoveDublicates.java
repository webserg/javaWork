package algoritms.collections;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by sergiy.doroshenko
 * Date: 5/19/11
 * Write code to remove duplicates from an unsorted linked list.
 */
public class LinkedListRemoveDublicates {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");
        list.add("one");
        list.add("two");
        list.add("five");
        list.add("seven");
        System.out.println(list);

        Set<String> set = new LinkedHashSet<>(list);
        list = new LinkedList<>(set);
        System.out.println(list);

    }
}
