package algoritms;

public class Fuctorial {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(f(4));
    }

    public static long f(int n) {

        if (n <= 1)
            return 1;
        return n * f(--n);
    }

}
