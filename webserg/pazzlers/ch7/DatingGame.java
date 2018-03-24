package webserg.pazzlers.ch7;

import java.util.Calendar;
import java.util.Date;

public class DatingGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(1999, Calendar.DECEMBER, 31);//y,m,d
        System.out.println(cal.get(Calendar.YEAR) + "");
        Date d = cal.getTime();
        System.out.println(d.getDay());
    }

}
