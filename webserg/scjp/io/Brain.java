package webserg.scjp.io;

import java.util.Scanner;

public class Brain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner("123 A 3b c,45, x5x,76 82 L");
        while (sc.hasNext()) {
            if (sc.hasNextInt())
                System.out.print(sc.nextInt() + " ");
            else sc.next();
        }

    }

}
