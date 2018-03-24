package collections.googleCollections;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Author: Sergiy Doroshenko
 * Date: Feb 22, 2010
 * Time: 6:35:53 PM
 */
public class TransformMap {
    public static void main(String[] args) {
        ImmutableMap<Integer, String> map =
                new ImmutableMap.Builder<Integer, String>()
                        .put(10, "10")
                        .put(20, "20")
                        .put(30, "30")
                        .build();

        Map<Integer, String> transformed = Maps.transformValues(map, new Function<String, String>() {
            public String apply(String from) {
                return "X" + from;
            }
        });

        System.out.println(transformed);

    }
}
