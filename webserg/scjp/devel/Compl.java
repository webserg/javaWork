package webserg.scjp.devel;

public class Compl {
    void crazyLoop() {
        var c = 0;
        JACK:
        while (c < 8) {
            JILL:
            System.out.println(c);
            if (c > 3) break JACK;
            else c++;
        }
    }

    public static void main(String[] args) {
        Compl compl = new Compl();

        compl.crazyLoop();
    }
}
