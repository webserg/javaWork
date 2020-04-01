package java8.lambda;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaException {
    public static void main(String[] args) {

        final List<String> list = Arrays.asList("A", "B", "C");

        final Consumer<String> consumer = aps -> {
            try {
                // maybe some other code here...
                throw new Exception("asdas");
            } catch (final Exception ex) {
                System.out.println("handling an exception...");
                throw new RuntimeException("asdas");
            }
        };
        list.forEach(consumer);

     

        Function<String, Integer> f =
                (String t) -> {
                    try {
                        throw new Exception("asdas");
                    }
                    catch(Exception e) {
                        throw new RuntimeException(e);
                    }
                };

    }

}



@java.lang.FunctionalInterface
interface CheckedFunction<T> {
    void apply(T t) throws IOException;
}
