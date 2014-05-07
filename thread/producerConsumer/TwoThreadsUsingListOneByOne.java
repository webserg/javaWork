package thread.producerConsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * we have two threads
 * one start to fill collection
 * another start to use collection only when first is finish
 * first start work only with empty collection
 * second must work only with full(must contain 10 elements) collection
 *
 * using wait notify version
 */
class TwoThreadsUsingListOneByOne {


    public static void main(String[] args) {
        final UseList useList = new UseList();
        Runnable producer = () -> {
                while (true) {
                    synchronized (useList.list) {
                        if (useList.list.size() > 0) {
                            try {
                                useList.list.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("start fill");
                            for (int i = 0; i < 10; i++) {
                                useList.list.add(i);
                                try {
                                    Thread.sleep(400);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("added " + i);
                            }
                            useList.list.notifyAll();
                            try {
                                useList.list.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        };
        final UseList useList2 = useList;
                Runnable consumer = ()-> {
                while (true) {
                    synchronized (useList2.list) {
                        System.out.println("start wait");
                        if (useList2.list.size() < 10) {
                            try {
                                useList2.list.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            for (int i = 0; i < 10; i++) {
                                try {
                                    System.out.println("use " + useList2.list.get(i));
                                     Thread.sleep(400);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            useList2.list.clear();
                            useList2.list.notifyAll();
                            try {
                                useList2.list.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        };

        Executors.newSingleThreadExecutor().execute(producer);
        Executors.newSingleThreadExecutor().execute(consumer);

    }
}

class UseList {
    public List<Integer> list =new ArrayList< >();

}