package collections.googleCollections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Author: Sergiy Doroshenko
 * Date: Feb 22, 2010
 * Time: 12:26:22 PM
 */
public class FilterList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A100", "B100", null, "B200", "B200");
        List<String> filtered = list.stream().filter((String input) -> input == null || input.startsWith("B")).collect(Collectors.toList());
        System.out.println("");
//        System.out.println(Joiner.on("; ").useForNull("B000").join(filtered));
        System.out.println(filtered);
    }
}
