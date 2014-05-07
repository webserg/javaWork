package webserg.scjp.overrideOverload;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Animal extends LivingBeing {
    public Animal() {
    }

    public Animal(String name) {

    }

    public void Animal() {
        System.out.println("not constructor");
    }

    public void eat() throws FileNotFoundException, SQLException {
        System.out.println("animal eat");
    }

    public void printYourSelf() {
        System.out.println("Animal");
    }

    public void live() {
        System.out.println("live");

    }
}
