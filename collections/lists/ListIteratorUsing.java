package collections.lists;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Note the argument to listIterator in the preceding idiom.
 * The List interface has two forms of the listIterator method.
 * The form with no arguments returns a ListIterator positioned
 * at the beginning of the list; the form with an int argument returns a ListIterator
 * positioned at the specified index. The index refers to the element that would be returned
 * by an initial call to next. An initial call to previous would return the element whose index was index-1.
 * In a list of length n, there are n+1 valid values for index, from 0 to n, inclusive.
 * <p/>
 * Intuitively speaking, the cursor is always between two elements the one that would be returned
 * by a call to previous and the one that would be returned by a call to next. The n+1 valid index values
 * correspond to the n+1 gaps between elements, from the gap before the first element to the gap after the last one.
 * The following figure shows the five possible cursor positions in a list containing four elements.
 */
public class ListIteratorUsing {
    public static void main(String[] args) {
        List<Integer> list = Collections.unmodifiableList(Lists.toList(9, 8, 7, 6, 5, 4, 3, 2, 1));
        List<Integer> listBack = new ArrayList<>();
        for (ListIterator<Integer> it = Lists.toList(1, 2, 3, 4, 5, 6, 7, 8, 9).listIterator(list.size());
             it.hasPrevious(); ) {
            listBack.add(it.previous());
        }
        Assert.assertEquals(list.toString(), listBack.toString());

        List<Integer> list2 = Collections.unmodifiableList(Lists.toList(1, 2, 3, 4, 10, 6, 7, 8, 9));
        List<Integer> listReplaced = replace(Lists.toList(1, 2, 3, 4, 5, 6, 7, 8, 9), 5, 10);

        Assert.assertEquals(list2.toString(), listReplaced.toString());


    }

    public static <E> List<E> replace(List<E> list, E val, E newVal) {
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
            if (val == null ? it.next() == null : val.equals(it.next()))
                it.set(newVal);
        return list;
    }
}
