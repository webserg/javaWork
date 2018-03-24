package algoritms.microsoftTask;

import java.util.Comparator;

/**
 * @author Sergiy Doroshenko
 */
public class CalendarNodeComparator implements Comparator<CalendarNode> {
    /**
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     */
    @Override
    public int compare(CalendarNode o1, CalendarNode o2) {
        if (o1.start.compareTo(o2.start) < 0 && o1.end.compareTo(o2.start) < 0)
            return -1;
        if (o2.start.compareTo(o1.start) < 0 && o2.end.compareTo(o1.start) < 0)
            return 1;
        return 0;
    }

}
