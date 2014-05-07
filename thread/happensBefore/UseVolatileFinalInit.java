package thread.happensBefore;


import java.util.Arrays;

/**
 * Created by webserg on 02.05.2014.
 * Эта программа так же может как остановиться, так и не остановиться. Но если остановится,
 * то может напечатать как "[1, 0]" так и "[1, 2]". Это связанно с тем, что запись элемента с индексом
 * 1 происходит позже записи в final-поле.
 *
 */
public class UseVolatileFinalInit {
    final int[] data;

    public UseVolatileFinalInit() {
        this.data = new int[]{1, 0};
        this.data[1] = 2;
    }

    static UseVolatileFinalInit instance;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                instance = new UseVolatileFinalInit();
            }
        }).start();

        while (instance == null) {/*NOP*/}
        System.out.println(Arrays.toString(instance.data));
    }
}
