package thread.pazzels;

import java.util.Random;
import java.util.concurrent.*;

class MyObject {

    public static Executor ex = new ScheduledThreadPoolExecutor(100);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Tracker t = new Tracker();
        Future<Tracker> f[] = new Future[1000];

        for (int i = 0; i < 1000; i++) {
            /*The code in MyFutureTask.call() would be executed sometime in the future*/
            f[i] = new FutureTask<Tracker>(new MyFutureTask(t));
            ex.execute((Runnable) f[i]);
        }

        /*Wait for all the future task to complete!*/
        for (int i = 0; i < 1000; i++) {
            f[i].get();
        }

        /*Print out the number of future task that we have completed*/
        System.out.println(t.getValue());    /*This prints the number of task executed - 1000*/
    }
}

class MyFutureTask implements Callable<Tracker> {

    Tracker myTracker;

    MyFutureTask(Tracker t) {
        myTracker = t;
    }

    @Override
    public synchronized Tracker call() throws Exception {

        /*Some complex business logic inserted at this point*/
        int rand = new Random().nextInt(1000);
        Thread.sleep(rand);

        myTracker.increment();
        return myTracker;
    }
}

class Tracker {
    Integer value = 0;

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}