package collections.scjp.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericsOldCode {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        ls.add("aa");
        ls.add("bb");
        ls.add("cc");
        ls.add("dd");
        Iterator<String> it = ls.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("---");
        List l = addE(ls);
        for (Object s : l) {
            System.out.println(s);
        }

        //List<Object> myL= new ArrayList<Ch>(); Error!! Type mismatch!!!
        Par[] myA = new Ch[3];

        ArrayList<Par> p = new ArrayList<Par>();
        p.add(new Ch());
        //p.add(new Obj());//Error!!!   not applicable for this argument

    }

    static List addE(List l) {
        l.add("aa");
        return l;
    }
}

class Obj {
}

class Par extends Obj {
}

class Ch extends Par {
}
