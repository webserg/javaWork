package webserg.scjp.dates;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Dates {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.roll(Calendar.MONTH, 4);
        System.out.println(c.getTime());
        DateFormat[] df = new DateFormat[6];
        Locale l = new Locale("ru", "RU");
        df[0] = DateFormat.getInstance();
        df[1] = DateFormat.getDateInstance();
        df[2] = DateFormat.getDateInstance(DateFormat.SHORT, l);
        df[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        df[4] = DateFormat.getDateInstance(DateFormat.LONG);
        df[5] = DateFormat.getDateInstance(DateFormat.FULL);

        NumberFormat nf = NumberFormat.getInstance();
        Currency cur = Currency.getInstance(l);
        for (DateFormat f : df) {
            System.out.println(f.format(d));
        }

        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL);


    }
}
