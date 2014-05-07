package webserg.scjp.override;

public class ReturnPrimitives {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}

class A1 {
    char a() {
        return (char) 128;
    }

}

class A2 extends A1 {
    char a() {
        return 2;
    }
}
