package collections.wildCards.wildCardsVsTypeParameter;

import java.util.Arrays;
import java.util.List;

/**
 * User: Sergiy Doroshenko
 * Date: Dec 6, 2010 12:30:24 PM
 */
public class ContainsMethod {
    public static void main(String[] args) {
        Object obj = 1;
        List<Object> objs = Arrays.<Object>asList(1, 3, "two");
        System.out.println(objs);
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        assert ints.contains(obj);
        assert ints.containsAll(objs);

    }
}
