package collections.wildCards;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 2:14:24 PM
 */
public class GenericMethodCall {
    public static <T> List<T> factory() {
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        List<?> list1 = GenericMethodCall.factory();
        List<?> list2 = GenericMethodCall.<Object>factory();
        //List<?> list3 = GenericMethodCall.<?>factory();/// Illegal

        List<List<? super Number>> nested = GenericMethodCall.<List<? super Number>>factory();// nested wild card are permitted
    }
}
