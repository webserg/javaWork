package webserg.effectiveJava.equals;

public class PointCanEqual {

    private final int x;
    private final int y;

    public PointCanEqual(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof PointCanEqual) {
            PointCanEqual that = (PointCanEqual) other;
            result = (that.canEqual(this) && this.getX() == that.getX() && this.getY() == that.getY());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (41 * (41 + getX()) + getY());
    }

    public boolean canEqual(Object other) {
        return (other instanceof Point);
    }
}