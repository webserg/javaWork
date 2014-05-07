package patterns.visitor;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 18, 2010
 * Time: 4:31:08 PM
 */
public class VisitorSystem {
    public static void main(String[] args) {
        Item it1 = new ItemA();
        Item it2 = new ItemA();
        Item it3 = new ItemB();
        Item it4 = new ItemB();

        List<Item> items = Arrays.asList(new ItemA(),new ItemA(),new ItemB(),new ItemA(),new ItemB());
        Visitor v = new VisitorOne();

        for (Item i : items){
            i.accept(v);
        }

        System.out.println(items);

    }
}

