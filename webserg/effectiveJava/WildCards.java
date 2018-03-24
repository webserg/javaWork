package webserg.effectiveJava;

import java.util.List;

public class WildCards {
    public static void swapWildCard(List<?> list, int i, int j) {
        //list.set(i,list.set(j, list.get(i))); error you can't add any value to List<?> except null
    }

    public static <E> void swapGeneric(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));//you can add only E type
    }

    public static void main(String[] args) {

    }

}
