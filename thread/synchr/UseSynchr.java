package thread.synchr;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by webserg on 12.04.2014.
 */
public class UseSynchr {
    final Res res = new Res();
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        UseSynchr useSynchr = new UseSynchr();

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
        new Thread(thread3, "name3").start();
    }

    private void writer() {
        synchronized (res) {
            res.setFname("fname" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res.setSname("sname" + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void reader() {
        synchronized (res) {
            String r = res.getFullName();
            System.out.println(r);
            list.add(r);
            if (!check(r)) throw new ConcurrentModificationException("faile " + r);
        }
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

class Res {
    private String fname = "";
    private String sname = "";


    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFullName() {
        return sname + fname;
    }


}