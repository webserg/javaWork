package webserg.pazzlers.ch9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UseDog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog = Dog.INSTANCE;
		System.out.println(dog);
		String fileName = "dog.ser";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream ous = new ObjectOutputStream(fos);
			ous.writeObject(dog);
			ous.close();
			
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Dog dog1 = (Dog) ois.readObject();
			System.out.println(dog1);
			System.out.println(dog==dog1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
/*
class Dog2 extends Dog{
	public Dog2(String name){
		super.(name);
	}
}
*/