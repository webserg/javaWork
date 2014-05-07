package collections.googleCollections;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * User: webserg
 * Date: 09.12.11
 */
public class TransformMap2 {
    public static void main(String[] args) {

        Map<String, Integer> map = ImmutableMap.of("a", 4, "b", 9);
        System.out.println("before = " + map);
        Function<Integer, Double> sqrt =
                new Function<Integer, Double>() {
                    public Double apply(Integer in) {
                        return Math.sqrt(in);
                    }
                };
        Map<String, Double> transformed = Maps.transformValues(map, sqrt);
        System.out.println("after = " + transformed);
    }
}
