package webserg.scjp.regexps;

import java.util.Scanner;

public class Scanners {

    public static void main(String[] args) {
        boolean b2, b;
        int i;
        String s, hits = "";
        Scanner s1 = new Scanner("1 true 34 hi");
        Scanner s2 = new Scanner("1 true 34 hi");

        while (b = s1.hasNext()) {
            System.out.println(s1.next());
        }

        while (b = s2.hasNext()) {
            if (s2.hasNextInt()) {
                System.out.println("int " + s2.nextInt());
            } else if (s2.hasNextBoolean()) {
                System.out.println("boolean " + s2.nextBoolean());
            } else {
                System.out.println("|" + s2.next());
            }
        }

    }
}
