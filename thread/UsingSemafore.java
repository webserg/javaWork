package thread;

import java.util.concurrent.Semaphore;

/**
 * Created by webserg on 14.05.2014.
 */
public class UsingSemafore {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire();
        semaphore.acquire();
        semaphore.release();
        semaphore.release();
//        semaphore.release();
        semaphore.acquire();
        semaphore.acquire();
        System.out.println("hren wam");
        semaphore.acquire();
        System.out.println("win");
    }
}
