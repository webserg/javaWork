package masteringLambdas;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

/**
 * {alpha=X, bravo=Y, charlie=Z}
 */
public class MethodReferences {
    public static void main(String[] args) {


        String str = "alpha-bravo-charlie";

        var map = new BuildMap().get();

        /**
         * Often, however, you want to invoke a method reference
         * with the method receiver as well as its arguments taken from the arguments
         * to the method reference. For this, you need an unbound method reference, so called
         * because the receiver is not 􀃥xed; rather, the 􀃥rst argument to the method reference
         * is used as the receiver. Unbound method references are easiest to understand when
         * there is only one argument;
         */

        map.replaceAll(str::replace);

        System.out.println(map);

        /*
        * Now let’s restart the example with map at its initial value, and again call
        replaceAll, this time with the unbound method reference String::concat, a reference
        to an instance method of String that takes a single argument. It seems strange
        to be using a one-argument instance method as a BiFunction, but in fact it is the
        method reference that is the BiFunction: it is passed two arguments, the key-value
        pair, and takes the 􀃥rst argument as the receiver, so the method itself is called like
        this:
        key.concat(value)
         */


        var map2 = new BuildMap().get();
        map2.replaceAll(String::concat);
        System.out.println(map2);
    }
}

class BuildMap implements Supplier<Map<String, String>> {
    @Override
    public Map<String, String> get() {
        Map<String, String> map = new TreeMap<>();
        map.put("alpha", "X");
        map.put("bravo", "Y");
        map.put("charlie", "Z");
        return new TreeMap<>(map);
    }
}
