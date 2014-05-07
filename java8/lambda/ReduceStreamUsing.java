package java8.lambda;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

/**
 * Created by webserg on 10.04.2014.
 */
public class ReduceStreamUsing {
    public static void main(String[] args) {
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        assertEquals(6, count);

        int acc = 0;
        for (Integer element : StreamUsing.asList(1, 2, 3)) {
            acc = acc + element;
        }
        assertEquals(6, acc);

        int c = Stream.of(1, 2, 3).reduce(0, (ac, element) -> ac + element);
        assertEquals(6, c);

        BinaryOperator<Long> addLongs = (x, y) -> x + y;
    }
}
