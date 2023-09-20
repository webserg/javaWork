package webserg.scjp.mock;

public class Switch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        float f = Float.NaN;
        Object x = new Object();
        if (x instanceof int[]) {
            int[] y = (int[]) x;
            System.out.println("--");
        }
        if (x instanceof String[]) {
            System.out.println("999");
        }
    }

    static void t(int k) {
        switch (k) {
            case 1:
                System.out.println("");
            default:
            case 2:
                System.out.println("");
        }
    }

//    static void t2(long k) {
//        switch (k) {
//            case 1:
//                System.out.println("");
//            default:
//            case 2:
//                System.out.println("");
//        }
//    }
}
