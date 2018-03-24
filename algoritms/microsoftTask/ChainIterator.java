package algoritms.microsoftTask;

/**
 * itarate through linked list
 *
 * @param <T>
 * @author Sergiy Doroshenko
 */
public class ChainIterator<T extends Node<T>> {

    T head;

    T tail;

    public ChainIterator(T head, T tail) {
        this.head = head;
        this.tail = tail;
    }

    public void add(T t) {
        if (tail == null) {
            tail = t;
            head = tail;
        } else {
            tail.setNext(t);
            tail = tail.getNext();
        }
    }


    public T getHead() {
        return head;
    }


    public void setHead(T head) {
        this.head = head;
    }


    public T getTail() {
        return tail;
    }


    public void setTail(T tail) {
        this.tail = tail;
    }
}
