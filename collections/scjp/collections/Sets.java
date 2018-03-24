package collections.scjp.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Sets {

    /**
     * @param args
     */
    public static void main(String[] args) {
		/*HashSet<String> s = new HashSet<String>(); 
		s.add("aa");
		s.add("bb");
		s.add("cc");
		s.add("dd");
		for (String st : s) {
			System.out.println(st);
		}
		System.out.println(s.add("aa"));
		*/
        E e1 = new E("first", "1");
        E e2 = new E("first", "2");
        TreeSet<E> tr = new TreeSet<E>();
        tr.add(e1);

        HashSet<E> h = new HashSet<E>();
        System.out.println(h.add(e1));
        System.out.println(h.add(e2));
        System.out.println("sets element:");
        for (E e : h) {
            System.out.println(e);
        }
        System.out.println("\n");
        HashMap<String, E> map = new HashMap<String, E>();
        System.out.println(map.put("first", e1));
        System.out.println(map.put("first", e2));
        System.out.println("maps element:");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }

    }

    private static class E {
        private String name;
        private String ll;

        public E(String n, String l) {
            name = n;
            ll = l;
        }

        public boolean equals(Object o) {
            if (!(o instanceof E))
                return false;
            E e = (E) o;
            return e.name.equals(name);
        }

        public int hashCode() {
            //System.out.println("E hash code");
            return name.hashCode();
        }

        public String toString() {
            return name + " " + ll;
        }
    }
}
