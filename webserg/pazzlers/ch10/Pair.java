package webserg.pazzlers.ch10;

import java.util.Arrays;
import java.util.List;

public class Pair<T> {
    private final T first;
    private final T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<?> p = new Pair<Object>(23, "skidoo");//Pair p has raw type, because doesn't has generic type
        System.out.println(p.first() + " " + p.second());
        for (String s : p.stringList())
            System.out.print(s + " ");
    }

    public T first() {
        return first;
    }

    public T second() {
        return second;
    }

    public List<String> stringList() {
        return Arrays.asList(String.valueOf(first), String.valueOf(second));
    }
}
