package webserg.scjp.ch1.finall;

class Clidder {
    private final void flipper() {
        System.out.println("Clidlet");
    }

}

public class Clidlet extends Clidder {
    public static void main(String[] args) {
        new Clidlet().flipper();
    }

    public final void flipper() {
        System.out.println("Clidlet");
    }
}
