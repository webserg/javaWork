package java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * the idea that all the  elements of a collection exist
 * and are represented somewhere  in memory. This means
 * that they are not capable of   representing more-general
 * data, such as infinite sets. Consider, for example, the
 * set of all prime numbers.    This cannot be modeled
 * as Set<Integer> because   we donâ€™t know what all the
 * prime numbers are, and we  certainly donâ€™t have enough
 * heap space to represent    them all. In Java 7 and earlier
 * versions, the only way to  model the set would be to
 * work with an Iterator representing  the set instead.
 * <p/>
 * Stream is not really data structure; instead , it's an abstraction
 * for handling data.
 * <p/>
 * the values of expressions are not
 * computed until they are needed.
 */
public class LazyEvaluationUsing {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("first", 1));
        students.add(new Student("second", 2));
        students.add(new Student("third", 3));
        students.add(new Student("fours", 1));
        students.add(new Student("fives", 5));

        students.stream().map(s -> s.getScore()).forEach(System.out::println);
        int sum = students.stream().map(s -> s.getScore()).reduce(0, (x, y) -> {
            return (x + y);
        });
        System.out.println(sum);
    }
}
