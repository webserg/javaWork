package thread.workerQueue;

/**
 * Created by sergiy.doroshenko
 * Date: 7/11/11
 */
public class TestSimpleWorkQueue {

    public static void main(String[] args) throws Exception {
        SimpleWorkQueue worker = new SimpleWorkQueue(5, 30);
        worker.addTasks();
        worker.runThreads();
        Thread.sleep(100000);
        System.out.println("-------------------");
        worker.addTasks();

       // worker.stopNow = true;
    }

}
