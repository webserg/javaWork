package algoritms.comparison;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 2:39:28 PM
 */
public class ComparableUse {

    //Unlike wildcards, type variables must always be bounded using extends, never super.

    public static <T extends Comparable<T>> T max(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }

    /**
     * Following the Get and Put Principle, we use extends with Collection because we get values of type
     * T from the collection, and we use we use super with Comparable because we put value of type T into
     * the compareTo method. We’ll see an example that would not type check if the super clause above was
     * omitted in the next section.
     *
     * @param coll collection
     * @param <T> param
     * @return max
     */
    public static <T extends Comparable<? super T>> T max3(Collection<? extends T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }

    public static <T extends Comparable<T>> T max2(Collection<T> coll) {
        Iterator<T> it = coll.iterator();
        T candidate = it.next();
        while (it.hasNext()) {
            T elt = it.next();
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }
    //Signatures for methods should be as general as possible to maximize utility. If one can replace a type
    //parameter by a wildcard then one should do so.


//    The contract for the Comparable<T> interface specifies three properties
//    1.if x.equals(y) then x.compareTo(y) == 0.
//    2.x.compareTo(y) < 0 if and only if y.compareTo(x) > 0.
//    3.if x.compareTo(y) < 0 and y.compareTo(z) < 0 then x.compareTo(z) < 0

    public static void main(String[] args) {

        assert max(Arrays.asList(1, 5, 66, 77, 899, 4, 55, 66)) == 889;
        assert max2(Arrays.asList(1, 5, 66, 77, 899, 4, 55, 66)) == 889;
        assert max3(Arrays.asList(1, 5, 66, 77, 899, 4, 55, 66)) == 889;

        List<? extends Fruit> fruits = Arrays.asList(

                new Apple("apple500",500.0d),
                new Apple("apple5",5.0d),
                new Orange("orange6",6.0d),
                new Apple("apple2",2.0d),
                new Orange("orange88",88.0d)

        );
        //Incorrect
       // assert max(fruits).equals(new Apple("apple500",500.0d));  //<T>max(java.util.Collection<T>) in algoritms.comparison.ComparableUse cannot be applied to (java.util.List<capture#309 of ? extends algoritms.comparison.Fruit>)

        assert max3(fruits).equals(new Apple("apple500",500.0d));   // so we need use wild cards!!!!

        System.out.println(max3(fruits));
    }
    
}
