package webserg.scjp.innerClass;

public class InnerStatic {
    static String x = "";

    static class MyInner {
        void doStaff() {
            System.out.println(MyInner.class);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MyInner().doStaff();
        InnerStatic.MyInner inner = new InnerStatic.MyInner();
        inner.doStaff();
        InnerStatic out = new InnerStatic();
        String x = InnerStatic.x;
        InnerStatic.MyInner inner2 = new InnerStatic.MyInner();
    }
}
