package thread.happensBefore;

import java.util.Arrays;

/**
 * Created by webserg on 02.05.2014.
 * <p>
 * Значения для final-полей объекта задаются в конструкторе. Если предположить, что объект построен «правильно»,
 * то как только объект построен, значения, присвоенные final-полям в конструкторе будут видны всем другим потокам без
 * синхронизации. Кроме того, видимые значения для любого другого объекта или массива, на который ссылается эти
 * final-поля будут по крайней мере, так же «свежи», как и значения final-полей.
 * Комментарий переводчика
 * Значения для final-полей объекта задаются в конструкторе или инициализаторе.
 * <p>
 * Эта программа может как остановиться, так и не остановиться
 * (будь instance — volatile, она бы гарантированно остановилась). Но если остановится, то гарантированно напечатает "[1, 2]"
 */
public class UseVolatileFinal {
    static UseVolatileFinal instance;
    final int[] data;

    public UseVolatileFinal() {
        this.data = new int[]{1, 2};
    }

    public static void main(String[] args) {
        new Thread(() -> {
            instance = new UseVolatileFinal();
        }).start();
        while (instance == null) {
            System.out.println("loop");
        }
        System.out.println(Arrays.toString(instance.data));
    }
}
