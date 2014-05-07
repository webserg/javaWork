package java7.diamondOperator;

import webserg.scjp.mock.T;

/**
 * Bluegarden
 * User: sedo
 * Date: 3/11/11
 */
public class ConstructorDiamondTest {
    public static void main(String[] args) {
        MyClassGenClass<Integer> myObject = new MyClassGenClass< >("");
        MyClassGenClass<Integer> myObject2 = new MyClassGenClass< >(""); //  ??? must work
    }

}
