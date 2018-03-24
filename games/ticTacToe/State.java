package games.ticTacToe;

/**
 * Created by webserg on 29.05.2014.
 */
public enum State {
    B, X, O;

    public static State opposite(State s) {
        return s == X ? O : X;
    }
}
