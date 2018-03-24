package webserg.pazzlers.ch8;

public class Heads extends CoinSide {
    public static final Heads INSTANCE = new Heads();

    private Heads() {
    }

    public String toString() {
        return "heads";
    }

}
