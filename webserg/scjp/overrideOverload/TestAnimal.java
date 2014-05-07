package webserg.scjp.overrideOverload;


import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TestAnimal {
    Integer i1 = new Integer(10);
    Integer i2 = 10;

    void doStaff(Animal a) {
        System.out.println("animal");
    }

    void doStaff(Horse h) {
        System.out.println("horse");
    }

    public static void main(String[] argv) {

        TestAnimal use = new TestAnimal();
        //Animal a= new Animal();

        //a.Animal();

        Animal ah = new Horse();

        try {
            ah.eat();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        Horse c = new Horse();

        c.eat();

        c.printYourSelf();
        c.buck();
        System.out.println();

        use.doStaff(ah);
        if (use.i1 == use.i2)
            System.out.println("ee");


        Horse h1 = new Horse();
        Animal a1 = h1;

        //a1.buck();
        try {
            a1.eat();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
