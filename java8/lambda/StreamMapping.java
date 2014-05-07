package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by webserg on 10.04.2014.
 */
public class StreamMapping {
    public static void main(String[] args) {
        List<String> collected = new ArrayList<>();
        for (String string : StreamUsing.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }
        assertEquals(StreamUsing.asList("A", "B", "HELLO"), collected);

        //====================================================

        List<String> collectedSt = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(toList());
        assertEquals(StreamUsing.asList("A", "B", "HELLO"), collectedSt);
    }
}
