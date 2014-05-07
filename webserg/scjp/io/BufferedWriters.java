package webserg.scjp.io;

import java.io.*;

public class BufferedWriters {

    /**
     * @param args
     */
    public static void main(String[] args) {
        File f = new File("c:\\temp\\webserg.scjp\\writer.txt");
        File f2 = new File("c:\\temp\\webserg.scjp\\writer2.txt");
        try {
            if (f.exists()) f.createNewFile();
            if (f2.exists()) f2.createNewFile();

            FileWriter fileWriter = new FileWriter(f);
            FileWriter fileWriter2 = new FileWriter(f2);

            BufferedWriter b1 = new BufferedWriter(fileWriter);
            BufferedWriter b2 = new BufferedWriter(b1);
            BufferedWriter b3 = new BufferedWriter(new PrintWriter(fileWriter2));
            b1.write("writer");
            b2.write("writer2");
            b3.write("writer3");
            b2.close();
            b1.close();
            b3.close();
            //OutputStream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
