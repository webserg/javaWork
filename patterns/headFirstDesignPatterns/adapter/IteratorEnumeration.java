package patterns.headFirstDesignPatterns.adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumeration<E> implements Enumeration<E> {

    Iterator<E> iterator;

    public IteratorEnumeration(Iterator<E> iter) {
        this.iterator = iter;
    }

    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    public E nextElement() {
        return iterator.next();
    }

}
