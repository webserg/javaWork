package collections.sets;

import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeSet;

/**
 * Created by webse on 2/8/2017.
 */
public class TreeSetComparator {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet<>(new Comp1());
        Date date = GregorianCalendar.getInstance().getTime();
        treeSet.add(new Moo("1",date));
        treeSet.add(new Moo("2",date));
        treeSet.add(new Moo("3",date));
        treeSet.add(new Moo("4",date));
        treeSet.forEach(e -> System.out.println(e));

    }
}

class Moo {
    private String name;
    private Date date;

    public Moo(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Moo{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moo moo = (Moo) o;

        if (!name.equals(moo.name)) return false;
        return date.equals(moo.date);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
class Comp1 implements Comparator<Moo>{
    @Override
    public int compare(Moo o1, Moo o2) {
        if(o2.getDate().after(o1.getDate())) return 1;
        else return -1;
    }
}
