package games.ticTacToe;

/**
 * Created by webserg on 29.05.2014.
 */
public final class Cell {
    int x;
    int y;


    private Cell(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public static Cell cell(int x, int y) {
        return new Cell(x, y);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        if (y != cell.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public static void main(String[] args) {
    }
}
