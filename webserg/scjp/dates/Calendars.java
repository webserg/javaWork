package webserg.scjp.dates;

import java.util.Calendar;
import java.util.TimeZone;

public class Calendars {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz);
        System.out.println(Calendar.getInstance());
    }

}
