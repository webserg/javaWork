package patterns.headFirstDesignPatterns.ducks;

public class MallardDuck extends Duck{
    public MallardDuck(){
	flyBehavior =  new FlyWithWinds();
	quackBehavior = new Quack();
    }
    @Override
    public void display() {
    }

}
