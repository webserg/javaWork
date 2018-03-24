package collections.lists;

import collections.sets.Boo;

import java.util.*;

public class ListUse {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] s = {"aa", "bb", "cc", "dd", "ff"};
        List<String> l = new ArrayList<String>(Arrays.asList(s));
        for (ListIterator<String> i = l.listIterator(l.size()); i.hasPrevious(); ) {
            String e = i.previous();
            System.out.println(e);
        }

        List<String> sl = l.subList(3, 4);

        System.out.println(sl);
        sl.add("ww");
        System.out.println(l);


        Boo b1 = new Boo("1");
        Boo b2 = new Boo("2");

        Boo b3 = new Boo("3");
        Boo b4 = new Boo("4");
        Boo b5 = new Boo("5");
        List<Boo> la = new LinkedList<Boo>();
        la.add(b1);
        la.add(b2);
        la.add(b3);
        la.add(b4);
        la.add(b5);
        System.out.println(la);
        Collections.shuffle(la);
        System.out.println(la);
        Collections.sort(la);
        System.out.println(la);
        System.out.println(Collections.binarySearch(la, new Boo("2")));


    }

}
