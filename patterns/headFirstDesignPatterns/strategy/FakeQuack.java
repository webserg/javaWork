package patterns.headFirstDesignPatterns.strategy;

public class FakeQuack implements QuackBehavior {
    public void quack() {
        System.out.println("Qwak");
    }
}
