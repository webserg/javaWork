package finance;

/**
 * Created by webserg on 23.11.2014.
 */
public class FVAnnual {
    public static void main(String[] args) {
        int c = 10000;
        int fv = 0;
        for (int i = 40; i > 0; i--) {
            fv += Math.pow(1 + 0.08, i);
        }
        fv = c * fv;
        System.out.println(fv);
        System.out.println(pmt());
        System.out.println(pv());
    }

    static double pmt() {
        int tmp = 0;
        double fv = 500000;
        for (int i = 1; i <= 25; i++) {
            tmp += Math.pow(1 + 0.08, i);
        }
        double pmt = fv / tmp;
        return pmt;
    }

    static double pv() {
        double tmp = 0;
        double c = 10000.0;
        for (int i = 1; i <= 25; i++) {
            tmp += 1.0 / Math.pow(1.0 + 0.05, i);
        }
        double pmt = c * tmp;
        return pmt;
    }
}
