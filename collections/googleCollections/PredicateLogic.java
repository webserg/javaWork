package collections.googleCollections;

/**
 * Author: Sergiy Doroshenko
 * Date: Feb 22, 2010
 * Time: 12:46:44 PM
 */

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.compose;
import static com.google.common.base.Predicates.in;
import static com.google.common.base.Predicates.not;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class PredicateLogic {
    public static void main(String[] args) {
        List<String> list1 = Lists.newArrayList("1", "2", "3");
        List<String> list2 = Lists.newArrayList("1", "4", "5");
        List<String> list3 = Lists.newArrayList("1", "4", "6");

        boolean result = and(not(in(list1)), in(list2), in(list3)).apply("1");

        assert !result;  // false
        ///-------------------------------------
        list1 = Lists.newArrayList("A1", "A2", "A3");
        result = compose(in(list1), new Function<String, String>() {
            public String apply(String from) {
                return "A" + from;
            }
        }).apply("1");

        assert result;  // true
    }
}
