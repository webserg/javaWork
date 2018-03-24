package webserg.pazzlers.ch2;

public class LongDivision {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000L;
        long t = 86400000000l;
        System.out.println(t);
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY + "/" + MILLIS_PER_DAY + " = " + MICROS_PER_DAY / MILLIS_PER_DAY);
    }

}
