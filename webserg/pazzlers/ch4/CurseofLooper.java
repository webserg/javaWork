package webserg.pazzlers.ch4;

public class CurseofLooper {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer i = new Integer(0);
        Integer j = new Integer(0);
        while (i <= j && j <= i && i != j) {
            System.out.println("infinine loop");
        }
        System.out.println(new Integer(0) == 0);
        System.out.println(new Integer(0) == new Integer(0));
    }
}
