package webserg.scjp.mock;

import java.util.Calendar;
import java.util.Formatter;

public class T {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Calendar c = Calendar.getInstance();
        Formatter ftw = new Formatter();
        ftw.format("%tr %tZ", c, c);
        System.out.println(ftw);

    }

}
