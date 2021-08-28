package collections.lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedListtUsing {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<String>();
        l.add("3");
        l.add("2");
        l.add("1");
        for (String s : l) {
//            l.add("b");
//            System.out.println(s);
        }
//        System.out.println(l.get(1));

        List<String> lc = new CopyOnWriteArrayList<>(Arrays.asList("1","2","3"));
        for (String s : lc) {
            lc.add("b");
            System.out.println(s);
        }
//        System.out.println(l.get(1));
    }
}
