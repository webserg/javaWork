package webserg.pazzlers.ch4;

public class InTheLoop {

    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    /**
     * @param args
     */
    public static void main(final String[] args) {
        int count = 0;
        for (int i = START; i <= END; i++) {
            count++;
        }
        System.out.println(count);
    }

}
