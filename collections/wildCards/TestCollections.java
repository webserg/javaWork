package collections.wildCards;

import java.util.*;

public class TestCollections {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<String, String>();
        List<String> l = new ArrayList<String>();
        Vector<String> v = new Vector<String>();
        LinkedList<String> lk = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>(16, .75f);
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        TreeSet<String> ts = new TreeSet<String>();
        TreeMap<String, String> tm = new TreeMap<String, String>();
        HashMap<String, String> hm = new HashMap<String, String>();
        Queue<String> qq = new PriorityQueue<String>();
        hs.add("aa");
        hs.add("bb");
        hs.add("cc");

        lhs.add("aa");
        lhs.add("bb");
        lhs.add("cc");

        qq.add("ff");
        qq.add("aa");
        qq.add("cc");

        l.addAll(hs);
        l.addAll(lhs);
        l.addAll(qq);

        Collections.sort(l);

        for (String string : hs) {
            System.out.println(string);
        }
        System.out.println("-----------------------------------");
        for (String string : lhs) {
            System.out.println(string);
        }
        System.out.println("------------------------------------");
        for (String string : qq) {
            System.out.println(string);
        }
        System.out.println("-------------------------------------");

        System.out.println("max=" + Collections.max(l));
        System.out.println("min=" + Collections.min(l));
    }

}
