package webserg.pazzlers.ch6;

public class Point {
    private final int x, y;
    private String name; // Cached at construction time

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        //Mistake, Never call orerridable method in constructor
        // use lazy initialization
        //name = makeName();
    }

    protected String makeName() {
        return "[" + x + "," + y + "]";
    }

    public final synchronized String toString() {
        if (name == null)
            name = makeName();
        return name;
    }
}
