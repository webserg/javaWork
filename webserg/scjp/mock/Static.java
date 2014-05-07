package webserg.scjp.mock;

public class Static {
    static int y = 1;

    static int getValue() {
        return y;
    }

    static int x = getValue();

    static T ter() {
        return new T();
    }

    ;
    Boolean[] b = new Boolean[5];

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(x);
        if (new Static().b[1] == true) System.out.println("true");
        ;
    }

}
