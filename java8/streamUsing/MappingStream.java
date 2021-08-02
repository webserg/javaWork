package java8.streamUsing;

import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * MAPPING STREAMS
 * Another way to create a primitive stream is by mapping from another
 * stream type
 */
public class MappingStream {

    private static Stream<Integer> mapping(IntStream stream) {
        return stream.mapToObj(x -> x);
    }
    private static Stream<Integer> boxing(IntStream stream) {
        return stream.boxed();
    }

    public static void main(String[] args) {
        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream = objStream.mapToInt(s -> s.length());

        var integerList = new ArrayList<Integer>();
        IntStream ints = integerList.stream()
                .flatMapToInt(x -> IntStream.of(x));
        DoubleStream doubles = integerList.stream()
                .flatMapToDouble(x -> DoubleStream.of(x));
        LongStream longs = integerList.stream()
                .flatMapToLong(x -> LongStream.of(x));
    }
}
