package webserg.pazzlers.ch8;

public class StrungOut {
    /**
     * @param args
     */
    public static void main(java.lang.String[] args) {
        String s = new String("hello world");
        System.out.println(s);
    }
}

/**
 * @author Sergiy Doroshenko
 * avoid reusing the names of platform classes
 * and never reuse class names from java.lang
 */
//class String {
class MyString {
    private final java.lang.String s;

    public MyString(java.lang.String s) {
        this.s = s;
    }

    public java.lang.String toString() {
        return s;
    }
}