package webserg.pazzlers.ch8;

import java.util.Arrays;

public class ImportDuty {
    public static void main(String[] args) {
        printArgs(1, 2, 3, 4, 5);
    }

    private static void printArgs(Object... args) {
        System.out.println(Arrays.toString(args));
    }
}
