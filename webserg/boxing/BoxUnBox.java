package webserg.boxing;

import java.util.*;

/**
 * author : Sergey Doroshenko
 * email: webserg@gmail.com
 * Date: Dec 5, 2008
 * Time: 2:37:57 PM
 */
public class BoxUnBox {
    public static int sum(List<Integer> ints) {
        int s = 0;
        for (int n : ints) {
            s += n;
        }
        return s;
    }

    /*
        this version is about 60 percent slower than the previous.
    */
    public static Integer sumInteger(List<Integer> ints) {
        Integer s = 0;
        for (Integer n : ints) {
            s += n;
        }
        return s;
    }

    public static void removeNegative(List<Double> v) {
        for (Iterator<Double> it = v.iterator(); it.hasNext(); ) {
            Double d = it.next();
            if (d < 0) v.remove(d);//it.remove();
        }
    }

    public static void removeNegative2(Collection<Double> v) {
        for (Iterator<Double> it = v.iterator(); it.hasNext(); ) {
            if (it.next() < 0) it.remove();
        }
    }


    public static void main(String[] args) {
        List<Integer> bigs = Arrays.asList(100, 200, 300);
        assert sumInteger(bigs) == sum(bigs);
        assert sumInteger(bigs) != sumInteger(bigs);  // not recommended
        List<Double> doubles = Arrays.asList(-100.0, 200.0, 300.0);
        List<Double> doubles2 = new ArrayList<Double>();
        doubles2.add(-100.0);
        doubles2.add(100.0);
        doubles2.add(100.0);
        doubles2.add(100.0);
        doubles2.add(-100.0);
        doubles2.add(-100.0);
        doubles2.add(100.0);
        //removeNegative(doubles2);
        removeNegative(doubles2);
        System.out.println(doubles2.toString());

        List<String> myCollection = new ArrayList<String>(10);
        myCollection.add("123");
        myCollection.add("456");
        myCollection.add("789");
        for (Iterator<String> it = myCollection.iterator(); it.hasNext(); ) {
            String myObject = it.next();
            //System.out.println(myObject);
            it.remove();
            //myCollection.remove(myObject); //can throw ConcurrentModificationException in single as
//well as multi-thread access situations.
        }
        System.out.println(myCollection.toString());

        //List<String> words = Lists.toList("hello", "world");

    }
}
