package algoritms.stack;

import java.util.ArrayList;
import java.util.List;

public class StackArrayList<T> implements Stack<T> {
    private final List<T> list = new ArrayList<>();

    public T peek() {
        if (isEmpty()) throw new IllegalStateException();
        return list.get(list.size() - 1);

    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException();
        return list.remove(list.size() - 1);
    }

    public void push(final T t) {
        list.add(t);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        StackArrayList<String> stack = new StackArrayList<>();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
