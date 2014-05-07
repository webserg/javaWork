package collections.wildCards.wildCardsVsTypeParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Sergiy Doroshenko
 * Date: Dec 7, 2010 12:43:02 PM
 */
public class RestrictionsOfWildCards {
    /*
    extend for read
    super for write
    * */

    public static void main(String[] args) {
        //How to do if we need both

        List<Number> nums = new ArrayList<Number>();
        List<? super Number> sink = nums;
        List<? extends Number> source = nums;
        for (int i = 0; i < 10; i++) sink.add(i);
        double sum = 0;
        for (Number num : source) sum += num.doubleValue();
        System.out.println(sum);
        //--------------------------------------------------------------------------------
        List<?> list = RestrictionsOfWildCards.factory();
        List<?> list2 = RestrictionsOfWildCards.<Object>factory();

        //List<?> list = RestrictionsOfWildCards.<?>factory();  // compile-time error

        List<List<?>> l = RestrictionsOfWildCards.<List<?>>factory();  // ok





    }
    //If a generic method call includes explicit type parameters, those type parameters must not be wildcards. 

    public static <T> List<T> factory() {
        return new ArrayList<T>();
    }

}
