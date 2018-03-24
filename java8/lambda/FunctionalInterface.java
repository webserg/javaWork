package java8.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * Created by webserg on 01.04.2014.
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        Predicate<Integer> atLeast5 = x -> x > 5;
        Collection<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(8);
//        Collection<Integer> intsatLeast5 = ints.parallelStream().filter(atLeast5).toArray();
//        boolean b = atLeast5(4);
//        System.out.println(new Boolean(atLeast5(4)));

        //ERROR BinaryOperator add = (x, y) -> x + y;
    }
}
