package webserg.pazzlers.ch7;

import java.util.HashSet;
import java.util.Set;

public class Differences {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int vals[] = {789, 678, 567, 456, 345, 234, 123, 12};
        Set<Integer> diffs = new HashSet<Integer>();
        for (int i = 0; i < vals.length; i++) {
            for (int j = i; j < vals.length; j++) {
                System.out.println(vals[i] + " - " + vals[j] + "=" + (vals[i] - vals[j]));
                diffs.add(vals[i] - vals[j]);
            }
        }
        System.out.println(diffs.size());
    }
}
