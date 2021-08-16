package webserg.effectiveJava.equals;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // An utterly wrong definition of equals
    public boolean equalsWrong(Point other) {
        return (this.getX() == other.getX() && this.getY() == other.getY());
    }

    // A better definition, but still not perfect
    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Point) {
            Point that = (Point) other;
            result = (this.getX() == that.getX() && this.getY() == that.getY());
        }
        return result;
    }
}
