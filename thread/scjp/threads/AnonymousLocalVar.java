package thread.scjp.threads;

public class AnonymousLocalVar {
    public static void main(String[] args) {
        AnonymousLocalVar anon = new AnonymousLocalVar();
        new Thread(anon.createRunnable()).start();
    }

    Runnable createRunnable() {
        final int i = 1111;
        return new Runnable() {

            public void run() {
                System.out.println(i);
            }
        };
    }


}
