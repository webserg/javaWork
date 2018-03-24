package collections;

import java.util.EnumSet;

/**
 * author : Sergey Doroshenko
 * email: webserg@gmail.com
 * Date: Dec 8, 2008
 * Time: 8:28:17 PM
 */
public class EnamSetUse {
    public static void main(String[] args) {
        EnumSet<Letters> e = EnumSet.noneOf(Letters.class);
        e.add(Letters.A);
        System.out.println(e);
    }

    ;

    enum Letters {A, B, C, D, E, F}
}
