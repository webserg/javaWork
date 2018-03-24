package collections.wildCards;


import java.util.LinkedList;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:44:31 PM
 */
public class TestGen {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<A> listA = new LinkedList<A>();
        List<B> listB = new LinkedList<B>();
        List<Object> listO = new LinkedList<Object>();
        m1(listA);
        m2(listA);
    }

    static void m1(List<? extends A> l) {
    }

    static void m2(List<A> l) {
    }

}

class B extends A {
}