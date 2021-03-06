package algoritms.microsoftTask;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * We need to merge two lists of calendar nodes
 * (which are ordered using the dates) into one also ordered using dates.
 * If nodes are intersecting in time you need to merge this nodes.
 *
 * @author Sergiy Doroshenko
 */
public class SheduleTest extends TestCase {
    private static final Comparator<CalendarNode> c = new CalendarNodeComparator();
    final Date now = new Date();
    Calendar nominalTime = Calendar.getInstance();

    static CalendarNode merge(CalendarNode root1, CalendarNode root2) {
        ChainIterator<CalendarNode> iter = new ChainIterator<CalendarNode>(null, null);
        CalendarNode tmp = null;
        while (root1 != null && root2 != null) {
            if (c.compare(root1, root2) < 0) {
                tmp = root1;
                root1 = root1.getNext();
            } else {
                tmp = root2;
                root2 = root2.getNext();
            }
            iter.add(tmp);
        }
        while (root1 != null) {
            tmp = root1;
            root1 = root1.getNext();
            iter.add(tmp);
        }

        while (root2 != null) {
            tmp = root2;
            root2 = root2.getNext();
            iter.add(tmp);
        }

        return iter.getHead();
    }

    public void testShedule() {
        Calendar c = Calendar.getInstance();

        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH, 10);
        Date d22_from = c.getTime();
        c.add(Calendar.HOUR, 2);
        Date d22_to = c.getTime();

        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH, 8);
        Date d21_from = c.getTime();
        c.add(Calendar.HOUR, 2);
        Date d21_to = c.getTime();

        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH, 9);
        Date d12_from = c.getTime();
        c.add(Calendar.HOUR, 2);
        Date d12_to = c.getTime();

        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH, 7);
        Date d11_from = c.getTime();
        c.add(Calendar.HOUR, 2);
        Date d11_to = c.getTime();

        Appointment app11 = new Appointment("11");
        Appointment app12 = new Appointment("12");
        Appointment app21 = new Appointment("21");
        Appointment app22 = new Appointment("22");
        CalendarNode cn22 = new CalendarNode(app22, d22_from, d22_to, null);
        CalendarNode cn21 = new CalendarNode(app21, d21_from, d21_to, cn22);
        CalendarNode cn12 = new CalendarNode(app12, d12_from, d12_to, null);
        CalendarNode cn11 = new CalendarNode(app11, d11_from, d11_to, cn12);


        CalendarNode cn22R = new CalendarNode(app22, d22_from, d22_to, null);
        CalendarNode cn12R = new CalendarNode(app12, d12_from, d12_to, cn22R);
        CalendarNode cn21R = new CalendarNode(app21, d21_from, d21_to, cn12R);
        CalendarNode headR = new CalendarNode(app11, d11_from, d11_to, cn21R);
        CalendarNode cur = headR;
        CalendarNode cur2 = merge(cn11, cn21);
        System.out.println(cur.toStringList());


        System.out.println(cur2.toStringList());
        while (cur != null && cur2 != null) {
            Assert.assertEquals(cur.app, cur2.app);
            System.out.println();
            cur = cur.getNext();
            cur2 = cur2.getNext();
        }
    }

    @Override
    public void tearDown() {
    }


}
