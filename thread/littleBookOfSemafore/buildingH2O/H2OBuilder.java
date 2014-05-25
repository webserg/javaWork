package thread.littleBookOfSemafore.buildingH2O;

import java.util.concurrent.*;

/**
 * Created by webserg on 21.05.2014.
 */
public class H2OBuilder {
    Semaphore mutex = new Semaphore(1);
    int oxygen = 0;
    int hydrogen = 0;
    CyclicBarrier barrier = new CyclicBarrier(3);
    Semaphore oxyQueue = new Semaphore(0);
    Semaphore hydroQueue = new Semaphore(0);

    public static void main(String[] args) {
        H2OBuilder b = new H2OBuilder();
        /*
        1 mutex.wait()
2 oxygen += 1
3 if hydrogen >= 2:
4 hydroQueue.signal(2)
5 hydrogen -= 2
6 oxyQueue.signal()
7 oxygen -= 1
8 else:
9 mutex.signal()
10
11 oxyQueue.wait()
12 bond()
13
14 barrier.wait()
15 mutex.signal()
         */
        Runnable oxygen = () -> {
            try {
                b.mutex.acquire();
                System.out.println("oxy");
                b.oxygen += 1;
                if (b.hydrogen >= 2) {
                    b.hydroQueue.release(2);
                    b.hydrogen -= 2;
                    b.oxyQueue.release();
                    b.oxygen -= 1;
                } else {
                    b.mutex.release();
                }
                b.oxyQueue.acquire();
                System.out.println("oxy bond");
                b.barrier.await();
                b.mutex.release();
                System.out.println("oxy bonded");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        /*
        1 mutex.wait()
2 hydrogen += 1
3 if hydrogen >= 2 and oxygen >= 1:
4 hydroQueue.signal(2)
5 hydrogen -= 2
6 oxyQueue.signal()
7 oxygen -= 1
8 else:
9 mutex.signal()
10
11 hydroQueue.wait()
12 bond()
13
14 barrier.wait()
         */
        Runnable hydrogen = () -> {
            try {
                b.mutex.acquire();
                System.out.println("hyd");
                b.hydrogen+=1;
                if(b.hydrogen >= 2 && b.oxygen >= 1){
                    b.hydroQueue.release(2);
                    b.hydrogen-=2;
                    b.oxyQueue.release();
                    b.oxygen-=1;

                }else{
                    b.mutex.release();
                }
                b.hydroQueue.acquire();
                System.out.println("hyd bond");
                b.barrier.await();
                System.out.println("hyd bonded");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        };

        ExecutorService s = Executors.newCachedThreadPool();
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 5; i++) {

            timer.schedule(oxygen,5*i,TimeUnit.SECONDS);
        }
        for (int i = 0; i < 10; i++)
            s.submit(hydrogen);
        s.shutdown();
        timer.shutdown();
    }
}
