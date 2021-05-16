package functionalProgramming;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * By definition, all functional interfaces have a single abstract method.
 * This doesn't mean they can have only one method, though. Several of
 * the common functional interfaces provide a number of helpful
 * default methods.
 */
public class Predicates {
    public static void main(String[] args) {
        Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
        Predicate<String> otherEggs = s -> s.contains("egg") && !s.contains("brown");
        ///better waty
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs2 = egg.and(brown);
        Predicate<String> otherEggs2 = egg.and(brown.negate());


        Consumer<String> c1 = x -> System.out.print("1: " + x);
        Consumer<String> c2 = x -> System.out.print(",2: " + x);
        Consumer<String> combined = c1.andThen(c2);
        combined.accept("Annie"); // 1: Annie,2:        Annie

        //Supplier is used when you want to generate or supply values
        //without taking any input.
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        System.out.println(d1);
        System.out.println(d2);
    }
}
