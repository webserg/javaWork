package thread.happensBefore;

/**
 * Created by webserg on 02.05.2014.
 * Эта программа (data — volatile, run — НЕ volatile) может как остановиться так и не остановиться в обеих моделях.
 * В случае остановки может напечатать как 0 так и 1 и в старой и в новой моделях памяти. Это вызвано тем,
 * что в обеих моделях можно «поднять» запись в не-volatile выше записи в volatile.
 */
public class UsingVolatileBad {
    static volatile int data = 0;
    static boolean run = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                data = 1;
                run = false;
            }
        }).start();

        while (run) {/*NOP*/}
        ;
        System.out.println(data);
    }
}
