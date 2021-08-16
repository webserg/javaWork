package webserg.effectiveJava.equals;

public class ColoredPointCanEqual extends PointCanEqual { // No longer violates symmetry requirement

    private final Color color;

    public ColoredPointCanEqual(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof ColoredPointCanEqual) {
            ColoredPointCanEqual that = (ColoredPointCanEqual) other;
            result = (that.canEqual(this) && this.color.equals(that.color) && super.equals(that));
        }
        return result;
    }

    @Override public int hashCode() {
        return (41 * super.hashCode() + color.hashCode());
    }

    @Override public boolean canEqual(Object other) {
        return (other instanceof ColoredPointCanEqual);
    }
}
