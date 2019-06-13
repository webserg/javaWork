package collections.sets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The Java platform contains three general-purpose Set implementations:
 * HashSet, TreeSet, and LinkedHashSet. HashSet, which stores its elements in a
 * hash table, is the best-performing implementation; however it makes no guarantees
 * concerning the order of iteration. TreeSet, which stores its elements in a red-black tree,
 * orders its elements based on their values; it is substantially slower than HashSet. LinkedHashSet,
 * which is implemented as a hash table with a linked list running through it, orders its elements based on
 * the order in which they were inserted into the set (insertion-order). LinkedHashSet spares its
 * clients from the unspecified, generally chaotic ordering provided by
 * HashSet at a cost that is only slightly higher.
 */
public class SetUse {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("aa");
        Set<String> s1 = new HashSet<>(c);
        s1.add("bb");
        Set<String> s2 = new HashSet<>(c);
        s1.retainAll(s2);
        System.out.println(s1);

        Set<String> hasNull = new HashSet<String>();
        hasNull.add(null);
        hasNull.add(null);
        hasNull.add(null);
        hasNull.add(null);
        hasNull.add(null);
        hasNull.add(null);
        hasNull.add(null);
        System.out.println("hasNull:" + hasNull);
        Foo f1 = new Foo("1");
        Foo f2 = new Foo("2");
        Foo f3 = new Foo("3");
        Foo f11 = new Foo("1");


        Set<Foo> t = new HashSet<>();
        System.out.println(t.add(f1));
        System.out.println(t);
        System.out.println(t.add(f11));
        System.out.println(f11);
        //set remains unchanged if you add element which set already contains
        System.out.println(t);

        System.out.println(f1.equals(f11));
        System.out.println(f1.hashCode());
        System.out.println(f11.hashCode());


    }

}

class Foo {
    static private int i = 0;
    private String name;
    private String secret;

    public Foo(String n) {
        name = n;
        secret = name + i++;
    }

    @Override
    public String toString() {
        return "name=" + name + ";secret=" + secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return name.equals(foo.name);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return name.hashCode();
    }

    public String getName() {
        return name;
    }
}
