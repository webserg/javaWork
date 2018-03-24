package webserg.pazzlers.ch4;

public class Looper {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int start = Integer.MAX_VALUE - 1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        for (int i = start; i < start + 1; i++) {
            System.out.println(i);
        }
        double i = Double.POSITIVE_INFINITY;
        while (i == i - 1) {
            System.out.println(i);

        }

    }

}
