package webserg.scjp.innerClass;

public class FooAnonim {
    /*public FooAnonim() {
        System.out.print("foo");
    }*/
    private abstract static class Ab {
    }

    class Bar {
        Bar() {
            System.out.print("bar");
        }

        void go() {
            System.out.println("hi");
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FooAnonim foo = new FooAnonim();
        foo.makeBar();
        (new FooAnonim() {
        }).makeBar();
        FooAnonim foo2 = new FooAnonim() {

        };
    }

    void makeBar() {
        (new Bar() {
        }).go();

    }

}
