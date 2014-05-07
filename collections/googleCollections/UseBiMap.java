package collections.googleCollections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Author: Sergiy Doroshenko
 * Date: Feb 22, 2010
 * Time: 1:59:32 PM
 */
public class UseBiMap {
    public static void main(String[] args) {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(Integer.valueOf(5), "Five");
        biMap.put(Integer.valueOf(1), "One");
        biMap.put(Integer.valueOf(9), "Nine");
        biMap.put(Integer.valueOf(5), "Another Five");
        biMap.put(Integer.valueOf(55), "Five");

        System.out.println(biMap);
        System.out.println(biMap.inverse());
    }
}
