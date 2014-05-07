package webserg.scjp.innerClass;

public class UseAnonymus {

    void useBar() {
        Bar bar = new Bar();
        bar.useFoo(new FooAnonim() {
        });
        FooAnonim foo = new FooAnonim() {
        };//note ; must be!!
        bar.useFoo(foo);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        UseAnonymus use = new UseAnonymus();
        use.useBar();
    }

}

interface Foo {

}

class Bar {
    void useFoo(FooAnonim foo) {
        System.out.println(foo);
        foo.makeBar();
    }
}