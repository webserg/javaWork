package patterns.observer;


public class Subject extends java.util.Observable {
    State state;

    public Subject(final State s) {
        state = s;
        state.setSubject(this);
    }

    public synchronized void setChanged() {
        super.setChanged();
    }

    public class NotifyTask extends Thread {
        private long delay;

        public NotifyTask(long d) {
            delay = d;
        }

        @Override
        public void run() {
            while (true)
                synchronized (this) {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Subject.this.notifyObservers(state);
                }
        }
    }
}

class State {
    private String name;
    private Integer point;
    private Subject subject;

    public State(String n) {
        name = n;
    }

    public void setSubject(Subject subj) {
        subject = subj;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
        subject.setChanged();
    }

    public String getName() {
        return name;
    }

}
