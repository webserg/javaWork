package webserg.scjp.devel;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:39:32 PM
 */
enum CoffeeSize {
    BIG(8), HUGE(10), OVERWHELMING(16) {
        public String echo() {
            return "AA";
        }
    };

    private int ounces; // an instance variable each enum

    //	 the arguments after the enum value are "passed"
    //	 as values to the constructor
    CoffeeSize(int ounces) {
        this.ounces = ounces; // assign the value to
        //		 an instance variable
    }
    //		 value has

    public int getOunces() {
        return ounces;
    }

    public String echo() {
        return "BB";
    }
}
