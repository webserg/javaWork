package java8.streamUsing;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamIteration {

    public static void main(String[] args) {
        Stream<Integer> oddNumberUnder100 = Stream.iterate(
                1, // seed
                n -> n < 100, // Predicate to specify when done
                n -> n + 2);
        oddNumberUnder100.forEach(System.out::println);

        reduceCount();

        minUsing();

        findAnyUsing();

        anyUsing();

        Stream<String> s = Stream.of("Monkey", "Gorilla", "Bonobo");
        s.forEach(System.out::print);
    }

    private static void anyUsing() {
        var list = List.of("monkey", "2", "chimp");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x ->
                Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); //        false
        System.out.println(list.stream().noneMatch(pred)); //        false
        System.out.println(infinite.anyMatch(pred));
    }

    private static void findAnyUsing() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        s.findAny().ifPresent(System.out::println); //
        infinite.findAny().ifPresent(System.out::println); //
    }

    private static void minUsing() {
        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s.min(Comparator.comparingInt(String::length));
        min.ifPresent(System.out::println);

        Stream<String> str = Stream.of("ape", "monkey", "bonobo");
        Optional<String> min2 = str.min((s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
            var res = s1.length() - s2.length();
            System.out.println(res);
            return res;
        });
        min2.ifPresent(System.out::println);

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent());
    }

    private static void reduceCount() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count());
    }
}
