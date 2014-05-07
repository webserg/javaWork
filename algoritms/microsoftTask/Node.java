package algoritms.microsoftTask;

/**
 * 
 * @author Sergiy Doroshenko
 *
 * @param <T>
 */
public interface Node<T> {
    T getNext();
    void setNext(T n);
}
