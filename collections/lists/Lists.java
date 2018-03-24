package collections.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lists {
    /**
     * convert param to list
     *
     * @param arr var-arg
     * @param <T> type
     * @return list of type
     */
    public static <T> List<T> toList(T... arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }


    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list) {
        T t = list.get(0);
        for (T e : list) {
            if (e.compareTo(t) > 0) {
                t = e;
            }
        }
        return t;
    }

    //overload
//    public static int sum(List<Integer> ints) {
//        int sum = 0;
//        for (int i : ints) sum += i;
//        return sum;
//    }
    //overload
    public static String sum(List<String> strings) {
        StringBuffer sum = new StringBuffer();
        for (String s : strings) sum.append(s);
        return sum.toString();
    }


    /**
     * add param to list
     *
     * @param list
     * @param arr
     * @param <T>
     */
    public static <T> void addAll(List<T> list, T... arr) {
        for (T t : arr)
            list.add(t);
    }

    public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i <= src.size(); i++) {
            dst.add(src.get(i));
        }
    }

    public static void reverse(List<?> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] s = {"aa", "bb", "cc", "dd"};
        List<String> l = Arrays.asList(s);
        List<Integer> lint = Lists.<Integer>toList();
        List<Object> list = Lists.<Object>toList(1, "2", "3");
        // List<Integer> ints = <Integer>toList();  // compile-time error
        List<Number> nums = new ArrayList<Number>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(dbls);
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");
        System.out.println(list);

        assert max(dbls) == 3.14 : max(dbls);


        List<? extends Number> numsExt = ints;
        //  numsExt.add(3.14);  // compile-time error ? extends NUmber only for read
        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> dest = Arrays.asList(5, 6);
        Collections.copy(objs, dest);
        System.out.println(objs);
        assert objs.toString().equals("[5, 6, four]");

        reverse(l);
        System.out.println(l.toString());
        //TreeMap

    }
}
