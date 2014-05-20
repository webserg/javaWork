package thread.littleBookOfSemafore.barberShopProblem.semafores;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by webserg on 08.05.2014.
 * A barbershop consists of a waiting room with n chairs, and the
 * barber room containing the barber chair. If there are no customers
 * to be served, the barber goes to sleep. If a customer enters the
 * barbershop and all chairs are occupied, then the customer leaves
 * the shop. If the barber is busy, but chairs are available, then the
 * customer sits in one of the free chairs. If the barber is asleep, the
 * customer wakes up the barber. Write a program to coordinate the
 * barber and the customers.
 * The Little Book of Semaphores Allen B. Downey
 */
public class BarberShop {
    Semaphore mutex = new Semaphore(1);
    Semaphore customerSem = new Semaphore(0);
    Semaphore barberSem = new Semaphore(0);
    volatile int customerCount = 0;
    final int limit = 3;

    public static void main(String[] args) {
        final BarberShop shop = new BarberShop();
        Runnable customer = () -> {
            System.out.println(" customer new customer" + Thread.currentThread().getName());
            try {
                int tmp = 0;
                shop.mutex.acquire();
                try {
                    if (shop.customerCount < shop.limit) {
                        shop.customerCount++;
                    } else {
                        System.out.println("limit=" + shop.customerCount + " customer go out " + Thread.currentThread().getName());
                        return;
                    }
                } finally {

                    shop.mutex.release();
                }
                shop.customerSem.release();
                System.out.println(" customer wants getHairCut counter=" + shop.customerCount + "  " + Thread.currentThread().getName());
                shop.barberSem.acquire();
                shop.getHairCut();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable barber = () -> {
            while (true) {
                try {
                    shop.barberSem.release();
                    shop.customerSem.acquire();
                    shop.doCutHair();
                    shop.mutex.acquire();
                    shop.customerCount--;
                    shop.mutex.release();
                    System.out.println(" barber finish " + Thread.currentThread().getName());
                    shop.barberSem.release();
                    System.out.println(" barber ready " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(customer);
        Executors.newSingleThreadExecutor().execute(barber);
        Executors.newSingleThreadExecutor().execute(customer);
        Executors.newSingleThreadExecutor().execute(customer);
        Executors.newSingleThreadExecutor().execute(customer);
        for (int i = 0; i < 10; i++) {
            System.out.println("==========================================================");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Executors.newSingleThreadExecutor().execute(customer);
            Executors.newSingleThreadExecutor().execute(customer);
        }

    }

    public void getHairCut() {
        System.out.println(" customer getHairCut " + Thread.currentThread().getName());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doCutHair() {
        System.out.println(" barber doCutHair " + Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Customer implements Runnable {
    @Override
    public void run() {
        while (true) {

        }
    }

    public void getHairCut() {

    }
}

class Barber implements Runnable {
    @Override
    public void run() {
        while (true) {

        }
    }

    public void doCutHair() {

    }
}
