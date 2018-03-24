package java8.lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Lambda expressions provide a neater way of implementing java classes
 * that have only one function
 *
 * lambda exp is a way to put block of code into variable. In other words we want to
 * wrap up bits of logic in smth that can then be passed around.
 * external vs internal iteration
 *
 * syntax rules : expressions starts with list of params that can be accepted
 * and ends with some code, with na arrow to separating two.
 *
 * Some code easily understood to mean "here is the method definition
 * for the single method declared in the interface "
 *
 * return statement is inferred from the expression.
 * if method returns void the extra syntax is used to put an additional set of braces
 * around the code part of the lambda expression.
 * lambda exp. can contain multiple statements, the body must be surrounded by braces, and
 * the return key must always be present.
 *
 * */
public class PredicateUsing {
    public static void main(String[] args) {
        File dir = new File("c:\\dev\\software");
        File[] directories = dir.listFiles(f -> f.isDirectory());

        List<File> dirs = Arrays.asList(directories);
        List<String> d = new ArrayList<>();
        dirs.stream().map(f -> f.toString()).forEach(System.out::println);
        Object[] dirsStr2 = dirs.stream().map(f -> f.toString()).toArray();
        //========================================
//        Predicate<String> matched = s -> s.equalsIgnoreCase("volante");
//       dirs.stream().filter(matched).map(println);
    }
}
