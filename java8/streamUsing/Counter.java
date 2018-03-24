package java8.streamUsing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by webse on 3/13/2017.
 */
public class Counter {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        List<Integer> sources = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            sources.add(i);
        }
        //@formatter:off
        sources.stream()
                .map(x -> x * 2)
                .peek(x -> atomicLong.incrementAndGet())
                .filter(x -> x > 5)
                .forEach(System.out::println);
        //@formatter:on
        System.out.println(atomicLong.get());
    }
}
