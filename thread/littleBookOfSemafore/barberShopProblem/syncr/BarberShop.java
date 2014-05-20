//package thread.barberShopProblem.syncr;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.Semaphore;
//
///**
// * Created by webserg on 08.05.2014.
// * A barbershop consists of a waiting room with n chairs, and the
// * barber room containing the barber chair. If there are no customers
// * to be served, the barber goes to sleep. If a customer enters the
// * barbershop and all chairs are occupied, then the customer leaves
// * the shop. If the barber is busy, but chairs are available, then the
// * customer sits in one of the free chairs. If the barber is asleep, the
// * customer wakes up the barber. Write a program to coordinate the
// * barber and the customers.
// * The Little Book of Semaphores Allen B. Downey
// * <p>
// * A Mutex can be used in the same way as a built-in lock by replacing blocks of the form:
// * <p>
// * synchronized(lock) { * body * }
// * <p>
// * <p>
// * with the more verbose and awkward before/after construction:
// * <p>
// * try {
// * mutex.acquire();
// * try {
// * body *
// * }
// * finally {
// * mutex.release();
// * }
// * }
// * catch (InterruptedException ie) {
// * /* response to thread cancellation during acquire *
// * }
// * <p>
// * Unlike synchronized blocks, locking in standard Mutex classes is non-reentrant. If the lock is held,
// * even by the thread performing the acquire, the thread will block. While it is possible to define and use a
// * ReentrantLock as well, a simple Mutex class suffices in many locking applications.
// */
//public class BarberShop {
//    final Object mutex = new Object();
//    final Object customerSem = new Object();
//    final Object barberSem = new Object();
//    volatile int customerCount = 0;
//    final int limit = 3;
//
//    public static void main(String[] args) {
//        final BarberShop shop = new BarberShop();
//        Runnable customer = () -> {
//            System.out.println(" customer new customer" + Thread.currentThread().getName());
//            try {
//                synchronized (shop.mutex){
//                    if (shop.customerCount < shop.limit) {
//                        shop.customerCount++;
//                    } else {
//                        System.out.println("limit=" + shop.customerCount + " customer go out " + Thread.currentThread().getName());
//                        return;
//                    }
//                }
//                synchronized (shop.customerSem) {shop.customerSem.notify();}
//                System.out.println(" customer wants getHairCut counter=" + shop.customerCount + "  " + Thread.currentThread().getName());
//                shop.barberSem.acquire();
//                shop.getHairCut();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//        Runnable barber = () -> {
//            while (true) {
//                try {
//                    shop.barberSem.release();
//                    shop.customerSem.acquire();
//                    shop.doCutHair();
//                    synchronized (shop.mutex) {
//                        shop.customerCount--;
//                    }
//                    System.out.println(" barber finish " + Thread.currentThread().getName());
//                    shop.barberSem.release();
//                    System.out.println(" barber ready " + Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Executors.newSingleThreadExecutor().execute(customer);
//        Executors.newSingleThreadExecutor().execute(barber);
//        Executors.newSingleThreadExecutor().execute(customer);
//        Executors.newSingleThreadExecutor().execute(customer);
//        Executors.newSingleThreadExecutor().execute(customer);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("==========================================================");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            Executors.newSingleThreadExecutor().execute(customer);
//            Executors.newSingleThreadExecutor().execute(customer);
//        }
//
//    }
//
//    public void getHairCut() {
//        System.out.println(" customer getHairCut " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized void doCutHair() {
//        System.out.println(" barber doCutHair " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//
//class Customer implements Runnable {
//    @Override
//    public void run() {
//        while (true) {
//
//        }
//    }
//
//    public void getHairCut() {
//
//    }
//}
//
//class Barber implements Runnable {
//    @Override
//    public void run() {
//        while (true) {
//
//        }
//    }
//
//    public void doCutHair() {
//
//    }
//}
