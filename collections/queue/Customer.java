package collections.queue;

import java.util.concurrent.BlockingDeque;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 22, 2010
 * Time: 12:44:20 PM
 */
public class Customer implements Runnable{
    String name;
    private BlockingDeque<Integer> deque;

    public Customer(String name, BlockingDeque<Integer> deque) {
        this.name = name;
        this.deque = deque;
    }

    @Override
    public synchronized void run() {
          for(int i=0;i<=10;i++){
              try{
                int j = deque.takeLast();
                System.out.println("take = " + j);
                Thread.sleep(100);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }

          }
    }
}
