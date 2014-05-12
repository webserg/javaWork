package thread.exercises.goteborg.timer;

public class Main {
    
    public static void main(String[] args) {
	Ticker ti = new Ticker(100);
	Timer tm = new Timer(1000);
	MainThread5 m = new MainThread5(ti);
	ti.addObserver(m);
	tm.addObserver(m);
	m.start();
	ti.start();
	tm.start();
    }

}
