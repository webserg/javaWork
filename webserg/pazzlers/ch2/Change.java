package webserg.pazzlers.ch2;

import java.math.BigDecimal;

public class Change {
    //String[] s = {"",""};
    int[] i = {1, 2};

    /**
     * @param args
     */
    public static void main(String[] args) {
        //problem
        System.out.println(2.00 - 1.10);
        //solution
        System.out.printf("%.2f%n", 2.00 - 1.10);
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }

}
