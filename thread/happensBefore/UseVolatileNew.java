package thread.happensBefore;

/**
 * Created by webserg on 02.05.2014.
 * Эта программа (data — НЕ volatile, run — volatile) гарантированно остановится И в старой
 * И в новой моделях памяти, но в старой может напечатать и 0 и 1,
 * а в новой гарантированно напечатает 1. Это связано с тем, что в новой модели памяти можно
 * «поднимать» запись в не-volatile, «выше» записи в volatile, но нельзя «спускать ниже».
 * А в старой можно было и «поднимать» и «спускать ниже».
 *
 * volatile-поля являются специальными полями, которые используются для передачи состояние между потоками.
 * Каждое чтение из volatile возвратит результат последней записи любым другим потоком; по сути, они указываются
 * программистом как поля, для которых не приемлемо увидеть «несвежее» (stale) значение в результате кэширования
 * или переупорядочения.
 * Компилятору и runtime-среде запрещено размещать их в регистрах. Они также должны убедиться,
 * что после записи в volatile данные «проталкиваются» (flushed) из кэша в основную память, поэтому
 * они сразу же становятся видны другим потокам. Аналогично, перед чтением volatile-поля кэш должен быть
 * освобожден, так что мы увидим значение в оперативной памяти, а не в кэше Существуют также дополнительные
 * ограничения на изменение порядка обращения к volatile переменным.

 *
 */
public class UseVolatileNew {
    static int data = 0;
    static volatile boolean run = true;
    public static void main(String[] args) {
        new Thread(()-> {
                data = 1;
                run = false;
            }
        ).start();

        while (run) {/*NOP*/};
        System.out.println(data);
    }
}
