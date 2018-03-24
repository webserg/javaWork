package patterns.observer;

import java.util.Calendar;
import java.util.Date;

public class TestObserver {

    /**
     * @param args
     */
    public static void main(String[] args) {

        AObserver a = new AObserver();
        BObserver b = new BObserver();

        State state = new State("first");
        Subject subject = new Subject(state);
        subject.addObserver(a);
        subject.addObserver(b);

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MILLISECOND, 1000);
        System.out.println(new Date());
        subject.new NotifyTask(1000l).start();
        for (int i = 0; i < 10; i++) {
            state.setPoint(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("stateA = " + a.getState());
            System.out.println("stateB =" + b.getState());
        }
        System.exit(0);
    }
}


