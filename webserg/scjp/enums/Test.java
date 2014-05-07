package webserg.scjp.enums;

public enum Test {
    A("a") {
        void t() {
        }
    }, B("b") {
        void t() {
        }
    };

    Test(String s) {
        System.out.println(s);
    }

    //public boolean equals(Object o){return super.equals(o);}
    abstract void t();
}
