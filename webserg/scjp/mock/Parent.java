package webserg.scjp.mock;

import java.io.Serializable;

public class Parent {
    private static class A {
    }

    void f(String s) {
        //Number
        String[][][] k = {
                {},
                {},
                {},
                {},
                {},
                {}
        };
    }

    public static void main(String[] args) {
        new Parent().f("");
        int i = Byte.parseByte("22");
        final long b = 20;
        int k = (byte) b + 23;
        switch (i) {
            case (byte) b + 23:
                System.out.println("L");
        }
    }
}

abstract class Child extends Parent implements Serializable {
    //synchronized void f(String s) throws Error{}
    abstract void f(String s);
}