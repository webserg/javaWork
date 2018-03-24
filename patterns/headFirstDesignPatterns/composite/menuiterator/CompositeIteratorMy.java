package patterns.headFirstDesignPatterns.composite.menuiterator;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIteratorMy implements Iterator<MenuComponent> {

    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();


    public CompositeIteratorMy(Iterator<MenuComponent> iter) {
        stack.push(iter);

    }

    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<MenuComponent> iter = stack.peek();
            if (!iter.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }

    }

    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> iter = stack.peek();
            MenuComponent component = iter.next();
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }
            return component;
        }
        return null;
    }

    public void remove() {
    }

}
