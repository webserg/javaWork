package webserg.scjp.overrideOverload;

public class Horse extends Animal {
    public Horse() {
    }

    public Horse(String name) {
        //super(name);

    }

    @Override
    public void eat() {
        System.out.println("horse eat");
    }

    public void buck() {
        printYourSelf();
    }

    public void printYourSelf() {
        System.out.println("Horse");
    }
}
