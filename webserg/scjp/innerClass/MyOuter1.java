package webserg.scjp.innerClass;

public class MyOuter1 {
    private String x = "out";

    final class MyInner {
        void seeOut() {
            System.out.println(x);
            System.out.println(this);
            System.out.println(MyOuter1.this);
        }
    }

    MyInner in = new MyInner();

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyOuter1.MyInner inner = new MyOuter1().new MyInner();
        inner.seeOut();
        MyOuter1.MyInner inner2 = new MyOuter1().new MyInner();
        MyOuter1 outer = new MyOuter1();
        MyInner inner3 = outer.new MyInner();

    }

}
