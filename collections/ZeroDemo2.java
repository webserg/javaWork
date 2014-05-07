package collections;
import java.util.ArrayList;
import java.util.List;

public class ZeroDemo2 {
    public static void main(String args[]) {

        // set up ArrayList and add strings to it

        List<String> stringlist = new ArrayList<String>();
        stringlist.add("string 1");
        stringlist.add("string 2");
        stringlist.add("string 3");

        // convert to String array

        Object out[] = stringlist.toArray();
        
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
            
        }
    }
}