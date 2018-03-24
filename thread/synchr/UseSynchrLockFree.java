package thread.synchr;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by webserg on 12.04.2014.
 */
public class UseSynchrLockFree {

    volatile Res res = new Res();

    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        UseSynchrLockFree useSynchr = new UseSynchrLockFree();

        Runnable thread1 = () -> {
            while (true) {
                useSynchr.writer();
            }
        };

        Runnable thread3 = () -> {
            while (true) {
                useSynchr.reader();
            }
        };

        new Thread(thread1, "name1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(thread1, "name2").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(thread1, "name3").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(thread1, "name4").start();
        new Thread(thread3, "name3").start();
    }

    private void writer() {
        final Res resWriter = new Res();
        resWriter.setFname("fname" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resWriter.setSname("sname" + Thread.currentThread().getName());
        res = resWriter;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void reader() {
        String r = res.getFullName();
        System.out.println(r);
        list.add(r);
        if (!check(r)) throw new ConcurrentModificationException("faile " + r);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean check(String r) {
        return r.charAt(9) == r.charAt(9 + 9 + 1);
    }
}
