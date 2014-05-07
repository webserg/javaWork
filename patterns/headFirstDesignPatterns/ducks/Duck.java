package patterns.headFirstDesignPatterns.ducks;

public abstract class Duck {
    public Duck() {
    }

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
	flyBehavior.fly();
    }

    public void performQuack() {
	quackBehavior.quack();
    }

    public void swim() {
	System.out.println("swim");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
