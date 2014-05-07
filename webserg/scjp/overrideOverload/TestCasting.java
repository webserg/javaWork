package webserg.scjp.overrideOverload;


public class TestCasting {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal();
        Horse horse = new Horse();

        // Horse h = animal; error!!!

        try {
            Horse h = (Horse) animal;// ClassCastException
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
        }
        // String s = (String)animal; error
        try {
            Animal a = (Horse) animal;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
        }
        Animal a = (Animal) horse;
        Animal a2 = horse;
        Animal a3 = new Horse();
        a3.eat();
        Horse h2 = (Horse) a3;
        a3.eat();
    }
}
