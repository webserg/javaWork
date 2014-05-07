package java8;

import com.google.caliper.Param;
import com.google.caliper.*;
import com.google.caliper.api.Macrobenchmark;
import com.google.caliper.runner.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapBenchmark extends Benchmark {

    private HashMap<Key, Integer> map;
    @Param
    private int mapSize;
    @Override
    protected void setUp() throws Exception {

        map = new HashMap<>(mapSize);
        for (int i = 0; i < mapSize; ++i) {
            map.put(Keys.of(i), i);
        }
    }

    public void timeMyOperation(int reps) {
        for (int i = 0; i < reps; i++) {
            map.get(Keys.of(i % mapSize));
        }
    }

    public static void main(String... args) {
    }
}
