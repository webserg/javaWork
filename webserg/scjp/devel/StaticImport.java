package webserg.scjp.devel;

import java.util.BitSet;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.System.out;

public class StaticImport {

    /**
     * @param args
     */
    public static void main(String[] args) {
        out.println(MAX_VALUE);
        out.println(Integer.toHexString(42));
        BitSet bitSet = new BitSet();
    }

}
