package webserg.pazzlers;

/**
 * @author Sergiy Doroshenko
 * Jul 19, 2008 1:10:22 AM
 * <p>
 * Class initialization is tricky, and auto-unboxing happens where you
 * least expect it
 * <p>
 * Moral: construct instance at end of class initialization
 * to fix: reorganize order of static fields
 */
public class Elvis {


    //REcursive class initialization 
    public static final Elvis ELVIS = new Elvis();
    private static final Boolean LIVING = true;

    static {
        System.out.println(LIVING);
    }

    private final Boolean alive = LIVING;

    {
        System.out.println(alive);
    }

    //before execute constructor system must init instance fields
    private Elvis() {
    }

    public static void main(String[] args) {

        System.out.println(ELVIS.lives() ? // auto-unboxing
                "Hung dog" : "hotel");
    }

    public final Boolean lives() {
        return alive;
    }

}
