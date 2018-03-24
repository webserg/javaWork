package webserg.pazzlers.ch8;

public class DoubleJeopardy extends Jeopardy {
    /*
     * the final modifier means something completely different on method and fields
     * On the method, final means that the nethod may not be overridden or hidden
     * on a field, final means the field may not be assigned more than once
     */
    public static final String PRIZE = "2 cents";

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(DoubleJeopardy.PRIZE);
    }

}
