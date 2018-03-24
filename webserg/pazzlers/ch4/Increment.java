package webserg.pazzlers.ch4;

public class Increment {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
            /*
             * int tmp = j;
             * j = j+1;
             * j = tmp;
             *
             */
        }
        System.out.println(j);
    }
}
