package webserg.scjp.devel;

class Coffee {
    CoffeeSize size; // each instance of Coffee has-a
    // CoffeeSize enum

    public static void main(String[] args) {
        Coffee drink1 = new Coffee();
        drink1.size = CoffeeSize.BIG;
        Coffee drink2 = new Coffee();
        drink2.size = CoffeeSize.OVERWHELMING;
        System.out.println(drink1.size.getOunces()); // prints 8
        System.out.println(drink2.size.getOunces()); // prints 16
        System.out.println(drink2.size.echo());
    }
}
