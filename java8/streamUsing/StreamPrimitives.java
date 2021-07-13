package java8.streamUsing;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrimitives {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println(stream.reduce(0, (s, n) -> s + n));

        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        System.out.println(stream2.mapToInt(x -> x).sum()); // 6

        /**
         * So far, this seems like a nice convenience but not terribly important.
         * Now think about how you would compute an average. You need to
         * divide the sum by the number of elements. The problem is that
         * streams allow only one pass. Java recognizes that calculating an
         * average is a common thing to do, and it provides a method to
         * calculate the average on the stream classes for primitives
         */

        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble()); // 2.0
    }
}
