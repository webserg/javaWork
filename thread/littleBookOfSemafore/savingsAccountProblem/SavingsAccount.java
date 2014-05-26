package thread.littleBookOfSemafore.savingsAccountProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by webserg on 26.05.2014.
 * The savings account problem: A savings account is share by several people, each
 * person might deposit or withdraw funds from the account subject to the constraint
 * that the balance of the account must never become negative. Give a java
 * implementation for the savings account.
 */
public class SavingsAccount {
    public static void main(String[] args) {
        Account account = new Account(100);
        Runnable person1 = () -> {
            while (true)
                try {
                    System.out.println("withdraw 20");
                    account.withdraw(20);
                    Thread.sleep(500);
                } catch (Exception e) {
                }
        };

        Runnable person2 = () -> {
            while (true)
                try {
                    System.out.println("withdraw 20");
                    account.deposit(20);
                    Thread.sleep(8000);
                } catch (Exception e) {
                }
        };

        ExecutorService timer = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            timer.submit(person1);
        }
        ExecutorService timer2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            timer2.submit(person2);
        }
    }
}

class Account {
    private int amount;

    Account(int amount) {
        this.amount = amount;
    }

    Lock lock = new ReentrantLock();
    Condition conAmount = lock.newCondition();

    public void deposit(int s) {
        try {
            lock.lock();
            amount += s;
            System.out.println("deposit amount = " + amount);
            conAmount.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int s) {
        try {
            lock.lock();
            while (amount - s < 0) {
                conAmount.await();
            }
            amount -= s;
            System.out.println("withdorwed amount = " + amount);
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}
