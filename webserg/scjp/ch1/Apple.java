package webserg.scjp.ch1;

public class Apple extends Fruit {
    protected int k = super.k;

    void useEcho() {
        this.echo();
        Fruit f = new Fruit();
        f.echo();
    }

    public static void main(String[] argv) {
        Apple a = new Apple();
        System.out.println(a.k);
        a.useEcho();
    }
}
