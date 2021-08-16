package thread.parallelStream;

import java.util.List;

public class ProcessingParallelReductions {
    public static void main(String[] args) {
        System.out.println(List.of(1, 2, 3, 4, 5, 6)
                .stream()
                .findAny().get());
        System.out.println("result of findAny for parallel streams is unpredictable");
        System.out.println(List.of(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .findAny().get());


        /**
         * <U> U reduce(U identity,
         * BiFunction<U,? super T,U> accumulator,
         * BinaryOperator<U> combiner)
         * We can concatenate a list of char values, using
         */

        System.out.println(List.of('w', 'o', 'l', 'f')
                .stream()
                .reduce("",
                        (s1, c) -> {
                            System.out.print(s1);
                            System.out.println(c);
                            return s1 + c;
                        },
                        (s2, s3) -> {
                            System.out.println("s2 = " + s2);
                            System.out.println("s3 = " + s3);
                            return s2 + s3;
                        }
                )); // wolf

        /**
         * On parallel streams, the reduce() method works by applying the
         * reduction to pairs of elements within the stream to create intermediate
         * values and then combining those intermediate values to produce a
         * final result. Put another way, in a serial stream, wolf is built one
         * character at a time. In a parallel stream, the intermediate values wo
         * and lf are created and then combined.
         */
        System.out.println(List.of('w', 'o', 'l', 'f')
                .parallelStream()
                .reduce("",
                        (s1, c) -> {
                            System.out.print(s1);
                            System.out.println(c);
                            return s1 + c;
                        },
                        (s2, s3) -> {
                            System.out.println("s2 = " + s2);
                            System.out.println("s3 = " + s3);
                            return s2 + s3;
                        }
                )); // wolf
    }
}
