package patterns.observer;

import java.util.Observable;

public class AObserver implements java.util.Observer{
	private String name;
	private int point;
	public void update(Observable o, Object arg){
		System.out.println("update A");
		name = ((State)arg).getName();
		point = ((State)arg).getPoint();
	}
	public String getState() {
		return getClass() + " "+  name + " " + point;
	}
}
