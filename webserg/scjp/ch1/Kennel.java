package webserg.scjp.ch1;

class Dog {
}

class Beagle extends Dog {
}

public class Kennel {
    public static void main(String[] argv) {
        Beagle b1 = new Beagle();
        Dog dog1 = new Dog();
        Dog dog2 = b1;
        //Beagle b2 = (Beagle)dog1;
        Beagle b4 = (Beagle) dog2;
    }
}
