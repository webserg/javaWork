package webserg.pazzlers.ch8;

public class Tails extends CoinSide {
    public static final Tails INSTANCE = new Tails();

    private Tails() {
    }

    public String toString() {
        return "tails";
    }

}
