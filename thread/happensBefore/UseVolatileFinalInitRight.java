package thread.happensBefore;


import java.util.Arrays;

/**
 * Created by webserg on 02.05.2014.
 * Эта программа как и первая так же может как остановиться, так и не остановиться.
 * Но если остановится, то гарантированно напечатает "[1, 2]". Так как запись элемента с индексом 1
 * происходит до записи в final-поле.
 * Что значит для объект быть «правильно построенным»? Это просто означает, что ссылка на объект «не утечет» до окончания процесса построения экземпляра
 */
public class UseVolatileFinalInitRight {
    static UseVolatileFinalInitRight instance;
    final int[] data;

    public UseVolatileFinalInitRight() {
        int[] tmp = new int[]{1, 0};
        tmp[1] = 2;
        this.data = tmp;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                instance = new UseVolatileFinalInitRight();
            }
        }).start();

        while (instance == null) {/*NOP*/}
        System.out.println(Arrays.toString(instance.data));
    }
}
