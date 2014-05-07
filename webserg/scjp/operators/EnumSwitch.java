package webserg.scjp.operators;

import java.util.ArrayList;
import java.util.List;

enum Color {
    red, green, blue, yellow, black
}

public class EnumSwitch {

    public static void main(String[] argv) {
        Color c = Color.black;
        switch (c) {
            case green:
                System.out.println("green");
                break;
            default:
                System.out.println("no color");
                break;
            case blue:
                System.out.println("blue");
                break;
            case black:
                System.out.println("black");
        }
        List<String> l = new ArrayList<String>();
        l.add("green");
        l.add("no color");
        l.add("blue");
        l.add("black");
        foreach:
        for (String s : l) {
            System.out.println(s);
            for (int i = 0; i < 5; i++) {
                if (i == 4) continue foreach;
                System.out.println(i);
            }
        }
    }
}
