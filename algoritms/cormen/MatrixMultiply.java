package algoritms.cormen;

import java.util.Arrays;

/**
 * Created by webserg on 10/9/2016.
 * matrix multiply row x column, a[2][3] x b[3][4] = c[2][4], include index must be equal 3==3
 */
public class MatrixMultiply {
    public static void main(String[] args) {
        int a[][] = new int[][]{{1, 3, 2}, {0, 4, -1}};
        int b[][] = new int[][]{{2, 0, -1, 1}, {3, -2, 1, 2}, {0, 1, 2, 3}};
        int c[][] = matrixMultiply(a, b);
        for (int[] aC : c) {
            System.out.println(Arrays.toString(aC));
        }
        int aSquare[][] = new int[][]{{1, 3}, {0, 4}};
        int aa[][] = squareMatrixMultiply(aSquare, aSquare);
        for (int[] aC : aa) {
            System.out.println(Arrays.toString(aC));
        }
    }

    private static int[][] matrixMultiply(int[][] a, int[][] b) {
        if(a[0].length != b.length) throw new IllegalArgumentException("matrix incompatible");
        int c[][] = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < b.length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                 c[i][j] = sum;
            }
        }
        return c;
    }

    private static int[][] squareMatrixMultiply(int[][] a, int[][] b) {
        if(a.length != b.length) throw new IllegalArgumentException("matrix incompatible");
        int len = a.length;
        int c[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
            }
        }
        return c;
    }

//    private static int[][] squareMatrixMultiply(int[][] a, int[][] b) {
//        int n = a.length;
//        int c [][] = new int[n][n];
//        if(n == 1){
//            c[0][0] = a[0][0] * b[0][0];
//        }else{
//            for(int i=0;i<a.length;i++){
//
//            }
//        }
//        return c;
//    }
}
