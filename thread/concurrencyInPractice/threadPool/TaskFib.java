package thread.concurrencyInPractice.threadPool;

import algoritms.Fibonachi;

/**
 * author : Sergey Doroshenko
 * email: webserg@gmail.com
 * Date: Dec 14, 2008
 * Time: 10:35:31 PM
 */
public class TaskFib implements Runnable {
    int f;
    long res;
    int num;
    Counter c;

    public TaskFib(Counter c, int num, int f) {
        this.c = c;
        this.f = f;
        this.num = num;
    }

    public void run() {
        System.out.println("task " + num + " started; all working task = " + ++c.c);
        if (c.c > 5) throw new RuntimeException();
        res = Fibonachi.f2(f);
        System.out.println(res + " task num " + num + " finished ");
        --c.c;
    }
}
