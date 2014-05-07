package webserg.scjp.ch1;

public enum Animals {
    Dog("woof"), Fish("burble");
    public String s;

    Animals(String s) {
        this.s = s;
    }

    public static void main(String... argv) {

        System.out.println(Animals.Dog.s + Animals.Fish.s);
    }
}
