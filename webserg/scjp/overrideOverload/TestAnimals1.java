package webserg.scjp.overrideOverload;

import java.sql.SQLException;

public class TestAnimals1 {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Animal1 a = new Animal1();
        Animal1 h = new Horse1();
        a.eat();
        h.eat();
    }
}

class Animal1 {
    void eat() throws SQLException {
        System.out.println("animal");
    }

    ;
}

class Horse1 extends Animal1 {

    public void eat() {
        System.out.println("horse");
    }

    ;
}

