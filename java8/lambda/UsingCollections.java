package java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * User: webserg
 * Date: 20.12.12
 */
public class UsingCollections {
    public static void main(String[] args) {
        List<Integer> counts = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            counts.add(i);
        }
        //Using internal iterators
        System.out.println("Using internal iterator");
//Passing a code block to forEach method
        counts.forEach(i -> {
            System.out.print(i * 2 + " ");
        });
        System.out.println();
        counts.parallelStream().filter(i -> i % 2 == 0).forEach(i -> {
            System.out.print(i + " ");
        });
    }
}
