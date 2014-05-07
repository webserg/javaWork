package webserg.scjp.mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(4);
        l.add(-4);
        for (Iterator<Integer> iter = l.iterator(); iter.hasNext(); ) {
            Integer e = iter.next();
            System.out.println(e);


        }
        if (1 % 2 == 0) System.out.println("000");

    }

}
