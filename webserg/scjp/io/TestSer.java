package webserg.scjp.io;

import java.io.*;

public class TestSer {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpecialSerial s = new SpecialSerial();
        try {
            FileOutputStream fos = new FileOutputStream("specialSerial.ser");
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(s);
            ous.close();
            System.out.print(++s.z + " ");
            FileInputStream fis = new FileInputStream("specialSerial.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            SpecialSerial s2 = (SpecialSerial) ois.readObject();
            ois.close();
            System.out.println(s2.y + " ");
        } catch (Exception e) {
            System.out.println("ext");
        }
    }
}

class SpecialSerial implements Serializable {
    transient int y = 7;
    static int z = 9;
}