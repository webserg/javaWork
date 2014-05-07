package webserg.scjp.mock;


public class IntegerGen {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer i = Integer.valueOf(18);
        Integer i2 = Integer.valueOf(18);
        System.out.println(i == i2);
        W w = new W();
        System.out.println("x" + w.x);
        C c = new W();
        System.out.println("x" + c.x);
        C c2 = new C();
        c2 = c;
        //w=(W)c2;
        //w=c;
        int[] m = {};
        int k = m.length;
        //PriorityQueue<E>
    }

}

class C {
    int x = 1;

    void t() {
    }
}

class W extends C {
    //int x=2;
    protected void t() {
    }
}
