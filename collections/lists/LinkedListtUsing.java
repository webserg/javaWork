package collections.lists;

import java.util.LinkedList;

public class LinkedListtUsing {
    public static void main(String[] args) {
	LinkedList<String> l = new LinkedList<String>();
	l.add("3");
	l.add("2");
	l.add("1");
	for (String s : l) {
	    System.out.println(s);
	}
	System.out.println(l.get(1));
    }
}
