package webserg.scjp.operators;

public class AssignmentVsEqualsTo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        boolean b = true;
        if (b = false) System.out.println("b is false");
        else System.out.println("b is true");

        int i;
        //System.out.println(i = 6);
        System.out.println(6 == (i = 6));

    }

}
