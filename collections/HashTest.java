package collections;

import java.util.*;

public class HashTest {
    public static void main(String[] argv) {
        int h = 123456789;
        int length = 2;
        System.out.println(h & 3);

        Map<Integer, String> t = new HashMap<Integer, String>();
        System.out.println(t.put(1, "one"));
        System.out.println(t.put(1, "one"));
        System.out.println(t.put(1, "two"));
        System.out.println(t.get(1));
        System.out.println("============HashSet=============");
        Set<String> s = new HashSet<String>();
        System.out.println(s.add("one"));
        System.out.println(s.add("one"));
        System.out.println(s.add("two"));
        Iterator<String> i = s.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("============TreeSet=============");
        Set<String> tree = new TreeSet<String>();
        System.out.println(tree.add("one"));
        System.out.println(tree.add("one"));
        System.out.println(tree.add("two"));
        Iterator<String> treeI = tree.iterator();
        while (treeI.hasNext()) {
            System.out.println(treeI.next());
        }
    }
}
