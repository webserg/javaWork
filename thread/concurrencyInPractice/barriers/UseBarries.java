package thread.concurrencyInPractice.barriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class UseBarries {
    Runnable action = new Runnable() {
        public void run() {

            System.out.println("Results are: ");
        }
    };
    final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, action);

    /**
     * @param args
     */
    public static void main(String[] args) {
        final UseBarries useBarries = new UseBarries();
        new Thread(new R1(useBarries.cyclicBarrier)).start();
        new Thread(new R2(useBarries.cyclicBarrier)).start();
    }

}

class R1 implements Runnable {
    final CyclicBarrier cyclicBarrier;

    public R1(CyclicBarrier cb) {
        this.cyclicBarrier = cb;
    }

    @Override
    public void run() {

        System.out.println("start 1");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("after sleep1");
        
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
         

    }

};

class R2 implements Runnable {
    final CyclicBarrier cyclicBarrier;

    public R2(CyclicBarrier cb) {
        this.cyclicBarrier = cb;
    }

    @Override
    public void run() {

        System.out.println("start 2");
        for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {

        }
        System.out.println("after sleep2");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

    }

}
