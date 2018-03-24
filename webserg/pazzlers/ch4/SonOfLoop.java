package webserg.pazzlers.ch4;

public class SonOfLoop {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String i = "0";
        System.out.println(i == i);
        while (i != i + 0) {
            System.out.println(i);
        }
    }

}
