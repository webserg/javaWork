package collections.sets;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

import junit.framework.TestCase;

public class TreeSetUsing extends TestCase {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeSet<String> t = new TreeSet<String>();
        ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<String>();
        Set<Character> s2 = new LinkedHashSet<Character>(8);
        Collections.addAll(s2, 'a', 'w', 'j', 'b');
        //	 iterators of a LinkedHashSet return their elements in proper order:
        System.out.println(s2.toString());

        TreeSet<Integer> times = new TreeSet<Integer>();
        times.add(1205); // add some departure times
        times.add(1505);
        times.add(1545);
        times.add(1830);
        times.add(2010);
        times.add(2100);
        System.out.println(times.toString());
        // Java 5 version
        TreeSet<Integer> subset = new TreeSet<Integer>();
        subset = (TreeSet) times.headSet(1600);
        System.out.println("J5 - last before 4pm is: " + subset.last());
        TreeSet<Integer> sub2 = new TreeSet<Integer>();
        sub2 = (TreeSet) times.tailSet(2000);
        System.out.println("J5 - first after 8pm is: " + sub2.first());
        // Java 6 version using the new lower() and higher() methods (NavigatableSet interface)
        System.out.println("J6 - last before 4pm is: " + times.lower(1600));
        System.out.println("J6 - first after 8pm is: " + times.higher(2000));
    }

}
