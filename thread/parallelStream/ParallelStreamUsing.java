package thread.parallelStream;

import java.util.List;

/**
 * A parallel stream is a stream that is capable of processing results
 * concurrently, using multiple threads. For example, you can use a
 * parallel stream and the map() operation to operate concurrently on the
 * elements in the stream, vastly improving performance over
 * processing a single element at a time.
 * Using a parallel stream can change not only the performance of your
 * application but also the expected results. As you shall see, some
 * operations also require special handling to be able to be processed in
 * a parallel manner.
 */
public class ParallelStreamUsing {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List.of(1,2,3,4,5)
                .stream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken = (System.currentTimeMillis()-start)/1000;
        System.out.println("Time: "+timeTaken+" seconds");

        //using parallelStream is not guaranties ordering, since several threads will execute work
        start = System.currentTimeMillis();
        List.of(1,2,3,4,5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        timeTaken = (System.currentTimeMillis()-start)/1000;
        System.out.println("Time: "+timeTaken+" seconds");

        //keep ordering
        start = System.currentTimeMillis();
        List.of(1,2,3,4,5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEachOrdered(s -> System.out.print(s + " "));
        System.out.println();
        timeTaken = (System.currentTimeMillis()-start)/1000;
        System.out.println("Time: "+timeTaken+" seconds");

    }

    private static int doWork(int input) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        return input;
    }
}
