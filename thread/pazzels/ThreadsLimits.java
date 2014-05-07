package thread.pazzels;

/**
 * User: Sergiy Doroshenko
 * Date: 12/31/10 7:52 PM
 * http://javapgmr.net/index.php?option=com_content&view=article&id=52:code-puzzle-2&catid=36:puzzles-questions&Itemid=54
 * What can you say about the value of x by the end of the program?
 * (Assume both threads ended its execution)
 */
public class ThreadsLimits extends Thread {
    static volatile int x;

    public void run() {
        for (int i = 0; i < 10; i++) {
            int temp = x;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            temp++;
            x = temp;
            System.out.println(Thread.currentThread().getName() + " " + x);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadsLimits();
        Thread t2 = new ThreadsLimits();

        t1.start();
        t2.start();

    }

}
