package webserg.scjp.ch1;

import java.util.Formatter;

public class VarArgsSimple {
    public static void main(String[] argv) {
        VarArgsSimple v = new VarArgsSimple();
        v.testVarArgs("a", "b", "c");
        for (int i = 0; i < 4; i++) {
            if (i % 4 == 0)
                System.out.println(i);
        }
        //String[] aa = {"1", "2", "3"};
        // String[] b = a;
        for (String k : argv)
            for (String j : argv)
                System.out.println("k = " + k + "j=" + j);
        Formatter formatter = new Formatter();

        assert false;
        //java.lang.AssertionError
        String s = "sdfs sdfsd sdf";
        String[] ss = s.split(s);
    }

    void testVarArgs(String a, String... b) {
        System.out.println(b.length);

    }

}
