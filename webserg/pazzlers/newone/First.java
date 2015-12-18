package webserg.pazzlers.newone;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by webserg on 12.06.2014.
 * http://www.infoq.com/presentations/java-puzzlers
 * What Does It Print?
 * (a) 0
 * (b) 4
 * (c) 6
 * (d) None of the above
 * <p>
 * <p>=========================================
 * MORAL
 * • Always declare collections using their interface types
 * – e.g., Map<String, Integer> = new HashMap<>();
 * •For API Designers
 * – Don’t violate the principle of least astonishment
 * •And by the way, Hashtable is almost never the right implementation to use
 * – For serial use, prefer HashMap; for concurrent use, prefer ConcurrentHashMap
 */
public class First {
    public static void main(String[] args) {
        String[] declaration = {"I", "Came", "I", "Saw", "I", "Left"};
        //Always declare collection using interface
        Map<String, Integer> firstIndex = new HashMap<>();
// don't do this       Hashtable<String, Integer> firstIndex = new Hashtable<>();
        for (int i = declaration.length - 1; i >= 0; i--)
            firstIndex.put(declaration[i], i);
        int inMap = 0;
        for (String word : declaration)
            if (firstIndex.containsKey(word))
//  it would be mistake          if (firstIndex.contains(word))
                inMap++;
        System.out.println(inMap);
    }


}
