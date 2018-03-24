package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shuffle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] a = {"aa", "bb", "cc", "dd"};
        String[] b = {"aa", "bb", "cc", "dd"};

        System.out.println(Arrays.toString(a));
        List<String> c = new ArrayList<>(Arrays.asList(b));
        Collections.shuffle(Arrays.asList(a));
        System.out.println(Arrays.toString(a));
        Collections.shuffle(c);
        System.out.println(c);
        System.out.println(Arrays.toString(b));

        Collections.sort(c);
        System.out.println(c);

    }

}
