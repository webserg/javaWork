package java7.diamondOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bluegarden
 * User: sedo
 * Date: 3/11/11
 */
public class DiamondOperatorTest {
    public static void main(String[] args) {
        // instead of this Map<String, List<String>> myMap = new HashMap<String, List<String>>(); use following
        Map<String, List<String>> myMap = new HashMap< >();

        List<String> list = new ArrayList< >();
        list.add("A");

        // The following statement should fail since addAll expects
        // Collection<? extends String>

        //list.addAll(new ArrayList< >());

        // The following statements compile:

        List<? extends String> list2 = new ArrayList< >();
        list.addAll(list2);
    }
}
