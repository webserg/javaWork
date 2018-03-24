package algoritms.microsoftTask;

/**
 * @param <T>
 * @author Sergiy Doroshenko
 */
public interface Node<T> {
    T getNext();

    void setNext(T n);
}
