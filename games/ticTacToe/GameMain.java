package games.ticTacToe;

import java.util.Map;

/**
 * Created by webserg on 29.05.2014.
 */
public class GameMain {
    Map<Cell, State> field;
    Role control;

    public static void main(String[] args) {
        Role first = Role.White;

    }

    public void init() {
        field.put(Cell.cell(1, 1), State.B);
        field.put(Cell.cell(1, 2), State.B);
        field.put(Cell.cell(1, 2), State.B);
        field.put(Cell.cell(2, 1), State.B);
        field.put(Cell.cell(2, 2), State.B);
        field.put(Cell.cell(2, 3), State.B);
        field.put(Cell.cell(3, 1), State.B);
        field.put(Cell.cell(3, 2), State.B);

        control = Role.White;
    }

    public int goal(State mark, int x, int y) {
        if (isLine(mark, x, y) && !isLine(State.opposite(mark), x, y))
            return 100;
        else if (!isLine(mark, x, y) && !isLine(State.opposite(mark), x, y))
            return 50;
        else return 0;
    }

    public void next(Role role) {
        if (!field.containsValue(State.O) && !field.containsValue(State.X)) {
            mark(role.getState(), 2, 2);
        } else {

        }
    }

    public boolean isLine(State mark, int x, int y) {
        return isRow(mark, y);
    }

    public boolean isRow(State mark, int y) {
        for (int i = 1; i <= 3; i++)
            if (field.get(Cell.cell(i, y)) != mark) return false;
        return true;
    }

    public boolean iSColumn(State mark, int x) {
        for (int i = 1; i <= 3; i++)
            if (field.get(Cell.cell(x, i)) != mark) return false;
        return true;
    }

    public boolean isDiagonalFirst(State mark, int x, int y) {

        if (x == y) {
            for (int i = 1; i <= 3; i++)
                if (field.get(Cell.cell(i, i)) != mark) return false;
        }
        return true;
    }

    public boolean isDiagonalSecond(State mark, int x, int y) {

        if ((x == 2 && y == 2) || (Math.abs(x - y) == 2)) {
            for (int i = 1, k = 3; i <= 3; i++, k--)
                if (field.get(Cell.cell(i, k)) != mark) return false;
        }
        return true;
    }

    public boolean legal(Role w, int x, int y) {
        return field.get(Cell.cell(x, y)).equals(State.B) && control == w;
    }

    public boolean legal(Role w, Action a) {
        return a == Action.noop && control == w;
    }

    public boolean open() {
        return field.containsValue(State.B);
    }

    public void mark(State state, int x, int y) {
        field.put(Cell.cell(x, y), state);
    }
}
