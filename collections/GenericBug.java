package collections;

import java.util.HashMap;

/**
 * Created by sergiy.doroshenko
 * Date: 5/20/11
 */
public class GenericBug {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String res = map.get(new Integer(1));
        String res1 = map.get(1);
        String res2 = map.get(new Object());
        String res3 = map.get("");
    }
}
