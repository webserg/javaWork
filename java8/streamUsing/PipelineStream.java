package java8.streamUsing;

import java.util.ArrayList;
import java.util.Optional;


public class PipelineStream {
    public static void main(String[] args) {

        /***
         * The correct answer is 3. Lines 25–27 create a List with two
         * elements. Line 28 requests that a stream be created from that List.
         * Remember that streams are lazily evaluated. This means that the
         * stream isn't actually created on line 28. An object is created that
         * knows where to look for the data when it is needed. On line 29, the
         * List gets a new element. On line 30, the stream pipeline actually
         * runs. The stream pipeline runs first, looking at the source and seeing
         * three elements.
         */
        var cats = new ArrayList<String>();
        cats.add("Annie");
        cats.add("Ripley");
        var stream = cats.stream();
        cats.add("KC");
        System.out.println(stream.count());


    }

    /**
     * Suppose that you are given an Optional<Integer> and asked to print
     * the value, but only if it is a three‐digit number. Without functional
     * programming, you could write the following:
     */
    private static void threeDigit(Optional<Integer> optional) {
        if (optional.isPresent()) { // outer if
            var num = optional.get();
            var string = "" + num;
            if (string.length() == 3) // inner if
                System.out.println(string);
        }
    }

    private static void threeDigitFunc(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }

}