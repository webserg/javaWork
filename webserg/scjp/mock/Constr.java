package webserg.scjp.mock;

import java.util.HashSet;
import java.util.Set;

public class Constr {
    private Constr() {
    }

    private void test() {
    }

    public static void main(String[] args) {
        new Constr().test();
        Set<String> s = new HashSet<String>();
        String[] ss = new String[10];
        Object[] o = ss;
        System.out.println(1 % 2);
    }

}
