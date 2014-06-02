package games.ticTacToe;

/**
 * Created by webserg on 29.05.2014.
 */
public enum Role {
    White,Black;

    public State getState(){
        return this == White ? State.X : State.O;
    }
}
