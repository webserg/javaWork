package webserg.scjp.override;

/**
 * author : Sergey Doroshenko
 * email: webserg@gmail.com
 * Date: Dec 3, 2008
 * Time: 1:58:57 PM
 * <p/>
 * Covariant return
 * jvm uses interfase of super class to run body of subclass's method
 */
public class ReturnType {
    public static void main(String[] args) {
        First f = new Second();
        String s = (String) f.method1();//need cast result because we try invoke super class method
        System.out.println(s);

    }
}

class First {
    Object method1() {
        System.out.println("first");
        return new String("parent");
    }

}

class Second extends First {
    String method1() {
        System.out.println("second");
        return new String("child");
    }

}
