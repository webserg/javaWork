package algoritms.stack;

public class SynchronizedArrayStack<T> implements Stack<T> {
    private final Stack<T> stack;

    public SynchronizedArrayStack(Stack stack) {
        this.stack = stack;
    }

    public synchronized void push(T elt) {
        stack.push(elt);
    }

    public synchronized T pop() {
        return stack.pop();
    }

    public synchronized boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public synchronized T peek() {
        return stack.peek();
    }

    @Override
    public synchronized int size() {
        return stack.size();
    }
}


