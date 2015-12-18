package thread.littleBookOfSemafore.matrixMuliplicationProblem;

/**
 * Created by webserg on 26.05.2014.
 */
public class MatrixMuliplicationProblem {
    public static void main(String[] args) {
        int n = 2;
        double[][] a, b, c;
        a = new double[n][n];
        b = new double[n][n];
        c = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = 2.0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = 3.0;
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    c[i][j] += a[i][k] * b[j][k];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
