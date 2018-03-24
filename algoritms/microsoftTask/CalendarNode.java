package algoritms.microsoftTask;

import java.util.Date;


public class CalendarNode implements Node<CalendarNode> {
    Appointment app;
    Date start;
    Date end;
    private CalendarNode next;

    public CalendarNode(Appointment app, Date start, Date end, CalendarNode next) {
        super();
        this.app = app;
        this.start = start;
        this.end = end;
        this.next = next;
    }

    /**
     * merge two CalendarNode if end1 < start2
     *
     * @param root1
     * @param root2
     * @return
     */
    public static CalendarNode mergeNode(CalendarNode root1, CalendarNode root2) {
        if (root1 == null || root2 == null) throw new IllegalArgumentException();

        Date start, end;

        if (root1.getStart().compareTo(root2.getStart()) < 0) {
            start = root1.getStart();
        } else {
            start = root2.getStart();
        }

        if (root1.getEnd().compareTo(root2.getEnd()) < 0) {
            end = root2.getEnd();
        } else {
            end = root1.getEnd();
        }
        Appointment app = Appointment.merge(root1.getApp(), root2.getApp());


        return new CalendarNode(app, start, end, null);
    }

    public String toStringList() {
        StringBuffer s = new StringBuffer();
        CalendarNode cur = this;
        while (cur != null) {
            s.append(cur);
            cur = cur.getNext();
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return "app = " + app + " start= " + start + " end= " + end + "\n";
    }

    @Override
    public CalendarNode getNext() {
        return next;
    }

    public void setNext(CalendarNode next) {
        this.next = next;
    }

    public Appointment getApp() {
        return app;
    }


    public void setApp(Appointment app) {
        this.app = app;
    }


    public Date getStart() {
        return start;
    }


    public void setStart(Date start) {
        this.start = start;
    }


    public Date getEnd() {
        return end;
    }


    public void setEnd(Date end) {
        this.end = end;
    }

}
