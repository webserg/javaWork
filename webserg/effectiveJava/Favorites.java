package webserg.effectiveJava;

import java.util.*;

public class Favorites {

    private Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

    // Typesafe heterogeneous container pattern - client
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(String.class, "Java2");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());

        List l = Collections.checkedList(new ArrayList<String>(), String.class);
        l.add("aa");
        l.add("bb");
        //l.add(1); //java.lang.ClassCastException:

        System.out.println(l);

    }

    public <T> void putFavorite(Class<T> type, T instance) {
        map.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(map.get(type));
    }

}
