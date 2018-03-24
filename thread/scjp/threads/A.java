package thread.scjp.threads;

class A extends Thread {
    private String holdA = "This is ";

    private int[] holdB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public void run() {
        for (int w = 0; w < 10; w++) {
            System.out.println(holdA + holdB[w] + ".");
        }
    }
}

class Thread11 {
    public static void main(String[] args) {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        A a = new A();
        a.start();
        a.start();
    }
}
