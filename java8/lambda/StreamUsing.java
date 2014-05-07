package java8.lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static junit.framework.Assert.assertEquals;

/**
 * Recall that one of the goals of     Project Lambda was to provide
 * the Java language with the ability
 * to easily express techniques
 * from functional programming. For
 * example, this means that Java will
 * acquire simple ways to write map()
 * and filter() idioms.  Originally, these idioms were
 * implemented by adding methods  directly to the classic Java collections
 * interfaces as default methods. However, because â€œmapâ€
 * and â€œfilterâ€ are relatively common  names, it was felt that the risk
 * of default implementation clash was too highâ€”many user-written
 * implementations of the collections  would have existing methods that
 * would not respect the intended     semantics of the new methods.
 * Instead, a new abstraction, called Stream, was invented.
 * INTRODUCING STREAM           A new abstraction,
 * called Stream,       was invented, which
 * is analogous to an Iterator. The Stream
 * interface is where all the new â€œfunctionally
 * orientedâ€ methods      have been placed.
 * The advantage that this change brings is that collections can now organise their own iteration internally,
 * transferring responsibility for parallelisation from client code into library code.
 */
public class StreamUsing {
    public static void main(String[] args) {
        File dir = new File("c:\\software");
        List<File> directories = Arrays.asList(dir.listFiles(File::isDirectory));

        directories.stream().map(File::toString).filter(s -> s.endsWith("es")).forEach(System.out::println);

        List<String> strings = new ArrayList<>();
        strings.add("aa");
        List<Integer> ints = strings.stream().map(String::length).filter(i -> i % 2 != 0).collect(toList());

        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        assertEquals(asList(1, 2, 3, 4), together);

        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        assertEquals(6, count);
    }

    @SafeVarargs
    static <T> List<T> asList(T... t) {
        return Arrays.asList(t);
    }
}
