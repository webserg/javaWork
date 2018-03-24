package webserg.pazzlers.ch9;

public class Greeter {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String greeting = "Hello world";
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print(greeting.charAt(i));
        }
    }

}
