package webserg.scjp.operators;

public class EqualityEnum {
    enum Color {Red, Green}

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Color c1 = Color.Green;
        Color c2 = Color.Green;
        Tree t = Tree.Oak;
        if (c1 == c2) System.out.println("==");
        if (c1.equals(c2)) System.out.println("equals");
    }

}
