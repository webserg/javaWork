package webserg.pazzlers.ch4;

public class LooperMeetsTheWolfMan {
    public static void main(String[] args) {
        Long i = Long.MIN_VALUE;
        System.out.println(i == -i);
        while (i != 0 && i == -i) {
            System.out.println("infinite loop");
        }
    }
}
