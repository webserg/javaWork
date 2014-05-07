package webserg.scjp;

public class IntegerRef {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer k;
        Integer g = new Integer(5);
        k = g + 2;
        k -= 1;

        System.out.println(k);
        k = g;
        System.out.println(k);
        k = 4;
        System.out.println(k);
        k += Integer.MAX_VALUE * 2;
        int k2 = 0;
        //k2 = k2 +  Integer.MAX_VALUE *2.0;
        System.out.println("k2 = " + k2);
        System.out.println(k);
        Integer i = new Integer(1) + new Integer(2);
        switch (i) {
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("other");
                break;
        }
    }

}
