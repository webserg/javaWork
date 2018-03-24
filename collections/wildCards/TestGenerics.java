package collections.wildCards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestGenerics {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(sum(l));
        List ll = l;
        List<String> lll = (List<String>) ll;
        lll.add("aaa");
        for (String s : lll)
            System.out.println(s);
        Set rawType = new HashSet();
        rawType.add("");
        rawType.add(1);
        Set<?> genType = new HashSet<String>();

    }

    static int sum(List<Integer> list) {
        int sum = new Integer(0);
        //for (Iterator iter = list.iterator(); iter.hasNext();) {
        for (int e : list) {


            //	int e = ((Integer) iter.next()).intValue();
            sum += e;
        }
        return sum;
    }

}
