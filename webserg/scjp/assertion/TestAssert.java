package webserg.scjp.assertion;

import java.util.Arrays;
import java.util.List;

public class TestAssert {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i[] = {1, 1};
        try {
            new TestAssert().c1();
        } catch (AssertionError e) {
            System.out.println("ass");
            // TODO: handle exception
        }

    }

    private void c1() {
        assert (true);
    }

    private Boolean c2() {
        return true;
    }
}

class TestAssert2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        test(2);
        List<Integer> ints = Arrays.asList(1, 2, 3);
        int s = 0;
        for (int n : ints) {
            s += n;
        }
        assert s == 6;
    }

    static void test(int i) {
        assert (i == 1);
        System.out.println("1");
    }
}