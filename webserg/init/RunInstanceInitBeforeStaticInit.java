package webserg.init;

/**
 * Created by sergiy.doroshenko
 * Date: 10/23/11
 */
public class RunInstanceInitBeforeStaticInit {
    private static RunInstanceInitBeforeStaticInit instance = new RunInstanceInitBeforeStaticInit();

    static {
        System.out.println("static second");
    }

    {
        System.out.println("instance first");
    }

    public static void main(String[] args) {
        new RunInstanceInitBeforeStaticInit();
    }
}
