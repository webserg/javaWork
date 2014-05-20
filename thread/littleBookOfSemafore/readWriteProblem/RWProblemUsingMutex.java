package thread.littleBookOfSemafore.readWriteProblem;

import java.util.concurrent.Executors;

/**
 * we have several threads to read
 * and two thread for write
 * <p>
 * <p>
 * using wait notify version
 */
class RWProblemUsingMutex {
    final UseList useList = new UseList();


    volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        final RWProblemUsingMutex obj = new RWProblemUsingMutex();
        for (int i = 0; i <= 3; i++) {
            obj.useList.list.add(i);
        }
        Runnable reader = () -> {
            while (true) {
                synchronized (obj) {
                    obj.counter++;
                }
                int s = obj.useList.list.size();
                for (int i = 0; i < s; i++) {
                    System.out.println(" reader = " + Thread.currentThread().getId() + "; value = " + obj.useList.list.get(i));
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }

                synchronized (obj) {
                    obj.counter--;
                    if (obj.counter == 0)
                        obj.notifyAll();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        };
        Runnable writer = () -> {
            while (true) {
                synchronized (obj) {
                    while (obj.counter > 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int s = obj.useList.list.size();
                    int k = obj.useList.list.get(s - 1);
                    for (int i = 0; i < s; i++) {
                        obj.useList.list.set(i, i + k);
                        System.out.println(" writer = " + Thread.currentThread().getId() + "; value = " + (i + k));
                    }
                    try {
                        Thread.sleep(500); // avoid starvation
                    } catch (InterruptedException e) {
                    }
                    obj.notify();
                }
            }

        };

        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(reader);
        Executors.newSingleThreadExecutor().execute(writer);
        Executors.newSingleThreadExecutor().execute(writer);

    }
}

