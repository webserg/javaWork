package webserg.scjp.enums;

public class EnumSwitch {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Color c = Color.Blue;
        switch (c) {
            case Green:
                System.out.println("green");
                break;
            case Blue:
                System.out.println("blue");
                break;
            case Red:
                System.out.println("red");
                break;
            default:
                System.out.println("other");
        }
        int b = 1;
        switch (b) {
            case 1:
                System.out.println(1);
            case 2147483647:
                System.out.println(Integer.MAX_VALUE);
        }
        System.out.println("======================================");
        switch (new Integer(7)) {
            case 1:
                System.out.println(1);
                break;
            default:
                System.out.println("default");
                break;
            case 9:
                System.out.println(9);

        }

        System.out.println("==========================================");
        int x = 2;
        if (++x == 3 && x != 5 ^ x++ == 4) {
            System.out.println("true");
        }
        System.out.println(x);
        System.out.println("===================================");
        for (short sh = 1, y = 2; y < 200; y++) {
            System.out.println(y);
        }
    }
}
