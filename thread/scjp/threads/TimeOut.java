package thread.scjp.threads;

public class TimeOut {
    static long limit = 2000;

    static boolean finish = false;

    public static void main(String[] args) throws Exception {
        new TimeOut().doStuff();
    }

    Object doStuff() throws Exception {
        Object result = null;
        new Thread(new Thread() {
            public void run() {

                try {
                    Thread.sleep(limit);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!finish)
                    throw new TimeOutException();


            }
        }).start();
        result = doStuff2();
        return result;
    }

    Object doStuff2() throws Exception {
        Thread.sleep(2001);
        finish = true;
        return new Object();
    }
}

class TimeOutException extends RuntimeException {

}