package algoritms.stack;

public interface Stack<T> {
    void push(final T t);

    T pop();

    T peek();

    boolean isEmpty();

    int size();
}
