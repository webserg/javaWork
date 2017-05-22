package java8.streamUsing;

import java8.lambda.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by webse on 2/16/2017.
 */
public class GroupByUsing {
    public static void main(String[] args) {
        Collection<Student> students = new ArrayList<>();
        students.add(new Student("a", 1, 2011));
        students.add(new Student("b", 2, 2011));
        students.add(new Student("c", 9, 2010));
        students.add(new Student("d", 4, 2011));
        students.add(new Student("f", 1, 2012));
        students.add(new Student("g", 6, 2011));
        students.add(new Student("h", 9, 2011));
        Comparator<Student> comparator = Comparator.comparing(student -> student.score);
        comparator = comparator.thenComparing(Comparator.comparing(student -> student.gradYear));
        List<Student> sorted = students.stream().sorted(comparator).collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }
}
