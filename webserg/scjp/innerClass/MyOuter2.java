package webserg.scjp.innerClass;


public class MyOuter2 {
    static String y = "stat";
    private String x = "out";

    static void staticMethodWithInnerClass() {

        class MyInner {
            MyInner() {
                System.out.println(y);
            }
        }
        MyInner inner = new MyInner();
    }

    public static void main(String[] args) {
        MyOuter2 outer = new MyOuter2();
        outer.doStuff();
        staticMethodWithInnerClass();
    }

    public void doStuff() {
        String z = "local";
        final String w = "localFinal";
        final class MyInner {
            public void seeOuter() {
                System.out.println("out is " + x);
                // System.out.println("loc is " + z);//Error!!
                System.out.println("loc is " + w);

            }
        }

        abstract class MyInnerAbstract {
            abstract void abstrMethod();
        }


        MyInner inner = new MyInner();
        inner.seeOuter();
    }
}
