package algoritms.comparison;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 6:08:29 PM
 */
public class StatisMembers {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<String> strings = Arrays.asList("one", "two");
        assert ints.getClass() == strings.getClass();
        System.out.println(ints.getClass());
    }
}
