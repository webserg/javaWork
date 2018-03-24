package thread;

/**
 * Created by webserg on 02.05.2014.
 */

import java.util.Scanner;

class Adder extends Thread {
    public int subtotal;
    private int[] row;

    public Adder(int[] row) {
        this.row = row;
    } // Adder

    public void run() {
        for (int r = 0; r < row.length; r += 1) {
            subtotal += row[r];
        } // for
    } // run
} // Adder

public class MatrixAdd {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);

        int rows, cols;
        rows = in.nextInt();
        cols = in.nextInt();

        int matrix[][] = new int[rows][cols];
        int total = 0;

        System.out.println(rows + " " + cols);
        for (int r = 0; r < rows; r += 1) {
            for (int c = 0; c < cols; c += 1) {
                matrix[r][c] = in.nextInt();
                System.out.print(matrix[r][c] + " ");
            } // for
            System.out.println();
        } // for

        Adder adders[] = new Adder[rows];

        for (int r = 0; r < rows; r += 1) {
            adders[r] = new Adder(matrix[r]);
            adders[r].start();
        } // for

        for (int r = 0; r < rows; r += 1) {
            adders[r].join();
            total += adders[r].subtotal;
        } // for
        System.out.println(total);
    } // main
} // Add


