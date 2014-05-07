package thread.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
 * @author Sergiy Doroshenko
 *
 * This class allowed clients to enqueue work items for asynchronous processing
 * by a background thread. When the work queue was no longer needed, the
 * client could invoke a method to ask the background thread to terminate itself
 * gracefully after completing any work that was already on the queue
 */
public class DisplayQueue extends WorkQueue {
    
    public static void main(String[] args) {
        int i=0;
        List<WorkItem> workItems = new ArrayList<WorkItem>();
        DisplayQueue displayQueue = new DisplayQueue();
        
        displayQueue.enqueue(new WorkItem("" + i++));
        displayQueue.enqueue(new WorkItem("" + i++));
        displayQueue.enqueue(new WorkItem("" + i++));
        displayQueue.enqueue(new WorkItem("" + i++));
        displayQueue.enqueue(new WorkItem("" + i++));
        displayQueue.enqueue(new WorkItem("" + i++));
        displayQueue.enqueue(new WorkItem("" + i++));
        displayQueue.enqueue(new WorkItem("" + i++));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        displayQueue.stop();
        
        // New way fom Java 5
        i=0;
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new WorkItem("one way" + i++));
        executor.execute(new WorkItem("one way" + i++));
        executor.execute(new WorkItem("one way" + i++));
        executor.execute(new WorkItem("one way" + i++));
        executor.execute(new WorkItem("one way" + i++));
        executor.execute(new WorkItem("one way" + i++));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        executor.shutdown();
        // another way with 6 threads working at the same time
        System.out.println("another way");
        i=0;
        ExecutorService executor2 = Executors.newFixedThreadPool(6);
        executor2.execute(new WorkItem("another way" + i++));
        executor2.execute(new WorkItem("another way" + i++));
        executor2.execute(new WorkItem("another way" + i++));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            
            e1.printStackTrace();
        }
        executor2.execute(new WorkItem("another way" + i++));
        executor2.execute(new WorkItem("another way" + i++));
        executor2.execute(new WorkItem("another way" + i++));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        executor2.shutdown();
    }

    @Override
    protected void processItem(Runnable workItem) throws InterruptedException {
        System.out.println(workItem);
        Thread.sleep(1000);
    }
}
 class WorkItem extends Thread{
     static int i=0;
     public WorkItem(String name){
         super(name);
     }
     @Override
    public void run() {
         try {
             

             if(i==0){
                
                 i=1;
                 Thread.sleep(5000);
             } else {
                
                 i = 0;
                 Thread.sleep(1000);
             }
             System.out.println(this);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
    }
     @Override 
    public String toString() {
        return getName();
    }
 }