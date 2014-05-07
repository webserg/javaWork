package collections.wildCards.wildCardsVsTypeParameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: Sergiy Doroshenko
 * Date: Dec 6, 2010 12:56:39 PM
 */
public class ListReverse {
    public static void main(String[] args) {
        List<?> l = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5));
        List<?> l2 = Collections.unmodifiableList(Arrays.asList(5, 4, 3, 2, 1));
        assert l2.equals(reverse(l));
        assert l2.equals(reverse3(l));
        System.out.println(reverse(l));
        System.out.println(reverse3(l));
    }

    public static <E> List<E> reverse(final List<E> list) {
        List<E> tmp = new ArrayList<E>();
        for (int i = 0; i < list.size(); i++) {
            E e = list.get(list.size() - i - 1);
            tmp.add(i, e);
        }
        return tmp;
    }

    public static void reverse2(List<?> list) {
        List<Object> tmp = new ArrayList<Object>(list);
        for (int i = 0; i < list.size(); i++) {
            //list.set(i, tmp.get(list.size() - i - 1));  // compile-time error
        }
    }
    //Instead, you can implement the method with the first
    // signature by implementing a private method with
    // the second signature, and calling the second from the first:


    public static List<?> reverse3(List<?> list) {
        return reverse(list);
    }


}
