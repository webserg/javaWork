package algoritms;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by webserg on 24.04.2014.
 */
public class MergeTwoLists<K extends Comparable<K>> {
    List<K> merge(List<K> a, List<K> b) {
        int s = a.size() + b.size();
        List<K> res = new ArrayList<>(s);
        ListIterator<K> aIt = a.listIterator();
        ListIterator<K> bIt = b.listIterator();
        for (int i = 0; i < s; i++) {
            if (!aIt.hasNext()) {
                while (bIt.hasNext()) {
                    res.add(bIt.next());
                }
                return res;
            }
            if (!bIt.hasNext()) {
                while (aIt.hasNext()) {
                    res.add(aIt.next());
                }
                return res;
            }
            K atmp = aIt.next();
            K btmp = bIt.next();
            if (atmp.compareTo(btmp) == -1) {
                res.add(atmp);
                bIt.previous();
            } else {
                res.add(btmp);
                aIt.previous();
            }
        }
        return res;
    }

    @Test
    public void testMerge1() {
        MergeTwoLists<Integer> mergeTwoLists = new MergeTwoLists<>();
        Assert.assertEquals(mergeTwoLists.merge(Arrays.asList(1, 2), Arrays.asList(3, 4)).toString(), "[1, 2, 3, 4]");
    }

    @Test
    public void testMerge12() {
        List<Integer> mergeTwoLists = new ArrayList<>(Arrays.asList(1, 2));
        mergeTwoLists.addAll(Arrays.asList(3, 4));
        Assert.assertEquals(mergeTwoLists.toString(), "[1, 2, 3, 4]");
    }

    @Test
    public void testMerge2() {
        MergeTwoLists<Integer> mergeTwoLists = new MergeTwoLists<>();
        Assert.assertEquals(mergeTwoLists.merge(Arrays.asList(1, 2), Arrays.asList()).toString(), "[1, 2]");
    }

    @Test
    public void testMerge3() {
        MergeTwoLists<Integer> mergeTwoLists = new MergeTwoLists<>();
        Assert.assertEquals(mergeTwoLists.merge(new LinkedList<>(Arrays.asList(1, 2)), new LinkedList<>(Arrays.asList(3, 4))).toString(), "[1, 2, 3, 4]");
    }
}

