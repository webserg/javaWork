package thread.executors.tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * FutureTask has method cancel that allow canceling the task.
 * It implements the Future interface. FutureTask object is created
 * by passing the object of the class which implements Callable.
 * And if before calling the run method, task is cancelled then on
 * calling run method of future task, will not allow running the thread. Find the example.
 */
public class FutureTaskTest {
    public static void main(String... args)throws Exception{
        FutureTask<String> ft= new FutureTask< >(new DemoTask());
//        boolean b=ft.cancel(true);
        ft.run();
        System.out.println(ft.get());
//        System.out.println(b);
    }
}

class DemoTask implements Callable<String> {
    public String call() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return "Task Done";
    }
}
