package java8.lambda;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.lang.ThreadLocal.withInitial;

/**
 * Created by webserg on 03.04.2014.
 */
public class ThreadLocalUsing {
    public static ThreadLocal<SimpleDateFormat> formatter = withInitial(()->new SimpleDateFormat("dd-MM-YYYY"));

    public static void main(String[] args) {
        System.out.println(formatter.get().getCalendar().getTime());
    }

}
