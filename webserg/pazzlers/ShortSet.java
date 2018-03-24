package webserg.pazzlers;

import java.util.HashSet;
import java.util.Set;

public class ShortSet {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<Short> set = new HashSet<Short>();
        for (short i = 0; i < 100; i++) {
            set.add(i);
            set.remove(i - 1);// we are removing Integer here, but set doesn't has Integer because it has Short
        }
        System.out.println(set.size());

    }

}
