package thread.parallelStream;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

/**
 * Like reduce(), the Stream API includes a three‐argument version of
 * collect() that takes accumulator and combiner operators, along
 * with a supplier operator instead of an identity.
 * <R> R collect(Supplier<R> supplier,
 * BiConsumer<R, ? super T> accumulator,
 * BiConsumer<R, R> combiner)
 */
public class CollectUsing {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("w", "o", "l",
                "f").parallel();
        SortedSet<String> set =
                stream.collect(TreeSet::new,
                        Set::add,
                        Set::addAll);
        System.out.println(set); // [f, l, o, w]

        /**
         * Recall that elements in a ConcurrentSkipListSet are sorted
         * according to their natural ordering. You should use a concurrent
         * collection to combine the results, ensuring that the results of
         * concurrent threads do not cause a
         * ConcurrentModificationException.
         */
        Stream<String> stream2 = Stream.of("w", "o", "l",
                "f").parallel();
        SortedSet<String> set2 =
                stream2.collect(ConcurrentSkipListSet::new,
                        Set::add,
                        Set::addAll);
        System.out.println(set2); // [f, l, o, w]
    }
}
