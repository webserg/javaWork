package thread.tij;

class DualSynch {
    private Integer syncObject = new Integer(0);

    public synchronized void f() {
        System.out.println("Inside f()" + syncObject++);
        System.out.println(syncObject);
        // Doesn't release lock:
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Leaving f()");
    }

    public void g() {
        while (true) {
            if (syncObject <= 0) System.exit(0);
            while (syncObject > 0)
                synchronized (syncObject) {
                    System.out.println("Inside g()" + syncObject--);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Leaving g()");

                }

        }

    }
}
