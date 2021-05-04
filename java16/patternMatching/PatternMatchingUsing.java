package java16.patternMatching;

/**
 * Pattern matching enables you to remove the conversion step by changing the
 * second operand of the instanceof
 * operator with a type pattern, making your code shorter and easier to read:
 */
public class PatternMatchingUsing {

    public static double getPerimeter(Shape shape) throws IllegalArgumentException {
        if (shape instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (shape instanceof Circle c) {
            return 2 * c.radius() * Math.PI;

        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    public static boolean bigEnoughRect(Shape s) {
        if (!(s instanceof Rectangle rec)) {
            // You cannot use the pattern variable r here because
            // the predicate s instanceof Rectangle is false.
            return false;
        }
        // You can use r here.
        return rec.length() > 5;
    }

    public static boolean bigEnoughRect2(Shape s) {
        if (s instanceof Rectangle r && r.length() > 5) {
            // ...
            return r.length() > 5;
        }
        // You can use r here.
        return false;
    }

    public static void main(String[] args) {

    }


}
