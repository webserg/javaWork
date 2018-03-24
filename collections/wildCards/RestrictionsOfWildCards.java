package collections.wildCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:52:58 PM
 */
public class RestrictionsOfWildCards {
    public static void main(String[] args) {

        // List<?> list = new ArrayList<?>(); // compile-time error
        // Map<String,? extends Number> map = new HashMap<String, ? extends Number>(); // compile-time error

        List<Number> nums = new ArrayList<Number>();
        List<? super Number> sink = nums;
        List<? extends Number> source = nums;
        for (int i = 0; i < 10; i++) sink.add(i);
        double sum = 0;

        // for (Double d : source) sum += d;  // compile - time error I don't know why because in the book "Generics and Collections" it works :)

        List<List<? super Number>> numslist = new ArrayList<List<? super Number>>();  //nested wildcards are permitted!!!!!!
//        numslist.add(Arrays.asList(1, 2, 3));
//        numslist.add(Arrays.asList(2.78, 3.14));
        numslist.add(Arrays.asList(2.78, "", new Object()));
        System.out.println(numslist);

        //        One way to remember this restriction is that the relation between wildcards and ordinary types is
        //similar to the relation between interfaces and classes — a wildcards and interfaces are more general,
        //ordinary types and classes more specific, and instance creation requires the more specific information.
        //Consider the following three statements

    }
}
