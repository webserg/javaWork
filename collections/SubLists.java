package collections;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Item 47 Bloch
 * insight. Let’s call a sublist that contains
 * the first element of a list a prefix of the list. For example, the prefixes of (a, b, c)
 * are (a), (a, b), and (a, b, c). Similarly, let’s call a sublist that contains the last
 * element a suffix, so the suffixes of (a, b, c) are (a, b, c), (b, c), and (c). The
 * insight is that the sublists of a list are simply the suffixes of the prefixes (or
 * identically, the prefixes of the suffixes) and the empty list. This observation
 * leads directly to a clear, reasonably concise implementation:
 */
public class SubLists {
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }

    public static void main(String[] args) {
        SubLists.of(List.of("a", "b", "c")).forEachOrdered(System.out::println);
    }

}