package patterns.headFirstDesignPatterns.singleton.onDemandHolder;

/**
 * Created by webserg on 16.05.2014.
 */
public class Singelton {
    private String name = "ELVIS";

    private Singelton() {

    }

    private static class Holder {
        private static final Singelton instance = new Singelton();
    }

    public static Singelton getInstance() {
        return Holder.instance;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(Singelton.getInstance().getName());
    }
}
