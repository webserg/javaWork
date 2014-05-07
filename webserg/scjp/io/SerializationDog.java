package webserg.scjp.io;

import java.io.*;

public class SerializationDog {

    public static void main(String[] argv) {
        Color c = new Color("black");
        Dog dog = new Dog(c, 2);
        try {
            File d = new File("c:\\temp\\webserg.scjp\\");
            if (!d.exists())
                d.mkdir();
            File f = new File(d, "dog.ser");
            f.createNewFile();
            FileOutputStream fs = new FileOutputStream(f);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(dog);
            os.close();

            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fi);
            Dog d2 = (Dog) oi.readObject();
            System.out.println(d2.color);
            System.out.println(d2.len);
            System.out.println("name = " + d2.name);
            System.out.println(d2.size);
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Animal {
    String name = "first";
    int size;

    Animal() {
        size = 67;
    }

    Animal(String n) {
        name = n;
        size = 67;
    }
}

class Dog extends Animal implements Serializable {
    transient Color color;
    int len;

    Dog(Color c, int l) {
        //super("aaaa");
        name = "second";
        color = c;
        len = l;
    }    /*
	private void writeObject(ObjectOutputStream ou) throws IOException{
		ou.defaultWriteObject();
		ou.writeObject(color.toString());
		ou.writeInt(len);
	}
	
	private void readObject(ObjectInputStream oi) throws IOException,ClassNotFoundException{
		oi.defaultReadObject();
		color = new Color((String) oi.readObject());
		len = oi.readInt();

		
	}*/
}

class Color {
    private String color;

    Color(String c) {
        color = c;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}
