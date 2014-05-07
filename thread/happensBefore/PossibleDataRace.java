package thread.happensBefore;

/**
 * Created by webserg on 02.05.2014.
 * Важное примечание: Обратите внимание, важно для обоих потоков синхронизироваться на одном и том же мониторе,
 * чтобы установить отношение «происходит-прежде» (happens-before relationship) должным образом. Это не тот случай,
 * когда все видимое потоку A, когда он синхронизируется на объекте X становится видно потоку B после того, как тот
 * синхронизирует на объекте Y. Освобождение и захват должны «соответствовать»
 * (то есть, быть выполнены с одним и тем же монитором), чтобы была обеспечена правильная семантика.
 * В противном случае код содержит гонку данных (data race).
 * http://habrahabr.ru/company/golovachcourses/blog/221133/
 */
public class PossibleDataRace {
    /*
    *
    * Следующая программа может как остановиться, так и не остановиться в рамках обеих моделей памяти
    * (так как в разных потоках происходит захват и освобождение мониторов различных объектов — lockA / lockB)
    * */
    static Object lockA = new Object();
    static Object lockB = new Object();
    static boolean run = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                synchronized (lockA) {
                    run = false;
                }
            }
        }).start();

        while (true) {
            synchronized (lockB) {
                if (!run) break;
            }
        }
    }
}
