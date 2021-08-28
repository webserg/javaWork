package algoritms.stack;

import java.lang.reflect.Array;

public class ArrayStack<T extends Number> implements Stack<T>{
    private final int MAX_ELEMENTS = 10;
    private T[] stack;
    private int index;
    public ArrayStack(Class<T> clazz, int capacity) {
        stack = (T[]) Array.newInstance(clazz, capacity);
        index = -1;
    }

    @Override
    public T pop() {
        if (index != -1) {
            return stack[index--];
        } else {
            throw new IllegalStateException("stack underflow");
        }
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public void push(T o) {
        if (index != stack.length - 1) {
            index++;                                        //1
            stack[index] = o;                             //2
        } else {
            throw new IllegalStateException("stack overflow");
        }
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

