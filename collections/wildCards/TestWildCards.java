package collections.wildCards;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:43:56 PM
 */
public class TestWildCards {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<AA> a = new ArrayList<AA>();
        a.add(new AA());
        Bar.doInsert(a);
        Bar.doInsert(new ArrayList<AA>());
    }

}

class DD {
}