package java8.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * User: webserg
 * Date: 20.12.12
 */
public class SearchingStudent {
    public static void main(String[] args) {
        Collection<Student> students = new ArrayList<>();
        students.add(new Student("a", 1, 2011));
        students.add(new Student("b", 2, 2011));
        students.add(new Student("c", 9, 2010));
        students.add(new Student("d", 4, 2011));
        students.add(new Student("f", 1, 2011));
        students.add(new Student("g", 6, 2011));
        students.add(new Student("h", 8, 2011));

        students.forEach(s -> {
            s.score++;
            System.out.println(s.toString());
        });

        Stream<Student> students2010 = students.parallelStream().filter(s -> s.gradYear == 2010);
        System.out.println("=============");
        students2010.forEach(s -> System.out.println(s));
        int max3 = students.parallelStream()
                .filter(s -> s.gradYear == 2011)
                .map(s -> s.score)
                .reduce(0, Math::max);
        System.out.println(max3);
        System.out.println("=============");
        students.stream()
                .filter(s -> {
                    System.out.println(s.getName());
                    return s.gradYear == 2011;
                });
//                .map(s -> s.score)
//                .reduce(0, Math::max);


//        List<Student> olderThan30 = students.stream().filter(p -> p.gradYear >= 2011).collect(Collectors.toCollection(() -> new ArrayList<Student>()));
//        System.out.println(olderThan30);

        //  int sumofstudents2011 = students.<Student>parallelStream().<Student>filter(s -> s.gradYear == 2010).<Integer>map(s -> s.score).reduce(0, Math::);


//    interface Collection<T> { // Default methods
//        public Collection<E> filter(Predicate<T> p)
//                default Collections.<T>filter;
//        public Collection<V> map(Extractor<T,V> e)
//                default Collections.<T>map;
//        public V reduce()
//                default Collections.<V>reduce
//    }

        Student studentWithMinScore = students.stream().min(Comparator.comparing(student -> student.getScore())).get();
        System.out.println(studentWithMinScore);
    }

}


