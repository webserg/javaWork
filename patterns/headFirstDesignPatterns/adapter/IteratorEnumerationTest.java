package patterns.headFirstDesignPatterns.adapter;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Enumeration;

public class IteratorEnumerationTest extends TestCase {
    public void testEnumeration() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("first");
        Enumeration<String> enumer = new IteratorEnumeration<String>(list.iterator());
        String s = "";
        while (enumer.hasMoreElements()) {
            s = enumer.nextElement();
        }
        assertTrue(s == "first");
    }
}
