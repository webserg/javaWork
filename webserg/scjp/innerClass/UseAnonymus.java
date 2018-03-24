package webserg.scjp.innerClass;

interface Foo {

}

public class UseAnonymus {

    /**
     * @param args
     */
    public static void main(String[] args) {
        UseAnonymus use = new UseAnonymus();
        use.useBar();
    }

    void useBar() {
        Bar bar = new Bar();
        bar.useFoo(new FooAnonim() {
        });
        FooAnonim foo = new FooAnonim() {
        };//note ; must be!!
        bar.useFoo(foo);
    }

}

class Bar {
    void useFoo(FooAnonim foo) {
        System.out.println(foo);
        foo.makeBar();
    }
}