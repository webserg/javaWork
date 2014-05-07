package webserg.scjp.enums;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:45:39 PM
 */
enum Animals {
    DOG("woof"), CAT("meow"), FISH("butble");
    String name;

    Animals(String s) {
        name = s;
    }
}
