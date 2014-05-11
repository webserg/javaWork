package collections.lists;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by webserg on 11.05.2014.
 */
public class SinglyLinkedListTests extends TestCase {
    public void testInsert() throws Exception {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        Assert.assertEquals("1 2 3 4 ", list.toString());

    }
}

