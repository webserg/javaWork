package java7.nio2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by sergiy.doroshenko
 * Date: 10/15/11
 */
public class UsingPath {
    public static void main(String[] args) {
        Path p1 = Paths.get("d:\\FOUND.001\\");
        System.out.println(p1);
        File f = p1.toFile();
        if (f.isDirectory()) {
            File[] listFiles = f.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].getName().endsWith(".CHK")) {
                    listFiles[i].renameTo(new File("d:\\FOUND.001\\" + listFiles[i].getName().replaceAll(".CHK", ".avi")));
                    System.out.println("d:\\FOUND.001\\" + listFiles[i].getName().replaceAll(".CHK", ".avi"));
                }
            }
        }
    }
}
