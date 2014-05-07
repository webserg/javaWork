package webserg.scjp;

class Dog {
}

class Beagle extends Dog {
}

public class Kennel {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Beagle b1 = new Beagle();
        Dog dog1 = new Dog();
        Dog dog2 = b1;
        //Beagle b4 = dog2;
    }

}
