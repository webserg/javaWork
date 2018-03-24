package collections.maps;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put(Alph.D, "enum D key");
        map.put(Alph.E, "enum E key");
        //E e = new E("e","ll");
        //map.put(e, "E key");
        Alph a = Alph.D;
        System.out.println(map.get(a));
        //System.out.println(map.get(Alph.E));
        //System.out.println(map.get(e));
        //java.lang.Enum
        vv();
    }

    public static void vv(String... s) {
        System.out.println(s.length);
        for (String string : s) {
            System.out.println(s);
        }
    }

    public static void vv() {
        System.out.println("vv");
    }


    static enum Alph {E, D, C}

    static class D {
    }

    static class C {
    }
}