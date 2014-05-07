package webserg.scjp.io;

import java.io.*;

public class Writer1 {

    public static void main(String[] argv) {
        try {
            boolean newFile = false;
            File file = new File("fileWriter1.txt");
            System.out.println(file.exists());
            //newFile = file.createNewFile();
            System.out.println(file.createNewFile());
            System.out.println(file.exists());

            FileWriter wr = new FileWriter(file);
            wr.write("Hello\nfile");
            wr.flush();
            wr.close();
            char[] c = new char[50];
            FileReader fr = new FileReader(file);
            fr.read(c);
            System.out.println(c.length);
            for (char d : c) {
                System.out.print(d);
            }
            fr.close();

            File file2 = new File("fileWriter2");
            FileWriter wr2 = new FileWriter(file2);
            PrintWriter prw = new PrintWriter(wr2);
            prw.println("Hello");
            prw.print("file");
            prw.close();
            wr2.close();
            FileReader fr2 = new FileReader(file2);
            System.out.println();
            BufferedReader br = new BufferedReader(fr2);
            while (true) {
                String s = br.readLine();
                if (s == null) break;
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
