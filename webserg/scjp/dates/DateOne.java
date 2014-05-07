package webserg.scjp.dates;

import java.text.DateFormat;
import java.util.Date;

public class DateOne {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Date d = new Date(1123631685981L);
        DateFormat df = DateFormat.getDateInstance();
        System.out.println(df.format(d));
    }
}
