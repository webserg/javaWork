package webserg.pazzlers.ch9;

import java.io.ObjectStreamException;

public class Dog extends Exception{
	private static int i;
	static {i++;}
	public static final Dog INSTANCE = new Dog();
	private Dog(){}
	public String toString(){
		return "Woof" + i;
	}
	private Object readResolve() throws ObjectStreamException{
		return INSTANCE;
	}

}
