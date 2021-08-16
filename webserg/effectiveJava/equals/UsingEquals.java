package webserg.effectiveJava.equals;

import java.util.Set;

/**
 * It is reflexive: for any non-null value x, the expression x.equals(x) should return true.
 * It is symmetric: for any non-null values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
 * It is transitive: for any non-null values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
 * It is consistent: for any non-null values x and y, multiple invocations of x.equals(y) should consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
 * For any non-null value x, x.equals(null) should return false.
 */


public class UsingEquals {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        Point q = new Point(2, 3);

        System.out.println(p1.equalsWrong(p2)); // prints true

        System.out.println(p1.equalsWrong(q)); // prints false

        Point p = new Point(1, 2);

        ColoredPoint cp = new ColoredPoint(1, 2, Color.RED);

        System.out.println(p.equals(cp)); // prints true

        System.out.println(cp.equals(p)); // prints false

//        The loss in symmetry can have unexpected consequences for collections. Here's an example:

        Set<Point> hashSet1 = new java.util.HashSet<Point>();
        hashSet1.add(p);
        System.out.println(hashSet1.contains(cp));    // prints false

        Set<Point> hashSet2 = new java.util.HashSet<Point>();
        hashSet2.add(cp);
        System.out.println(hashSet2.contains(p));    // prints true
    }
}
