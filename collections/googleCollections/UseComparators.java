package collections.googleCollections;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Comparator;
import java.util.List;

/**
 * Author: Sergiy Doroshenko
 * Date: Feb 22, 2010
 * Time: 1:28:24 PM
 */
public class UseComparators {
    public static void main(String[] args) {
        System.out.println("");

        List<GPerson> persons = Lists.newArrayList(
                new GPerson("Alfred", "Hitchcock"),
                null,
                new GPerson("Homer", "Simpson"),
                new GPerson("Peter", "Fox"),
                new GPerson("Bart", "Simpson"));

        Comparator<GPerson> lastNameComparator = new Comparator<GPerson>() {
            public int compare(GPerson p1, GPerson p2) {
                return p1.getLname().compareTo(p2.getLname());
            }
        };

        Comparator<GPerson> firstNameComparator = new Comparator<GPerson>() {
            public int compare(GPerson p1, GPerson p2) {
                return p1.getFname().compareTo(p2.getFname());
            }
        };

// order by last name ascending
        Ordering<GPerson> ordering = Ordering.from(lastNameComparator);
        //[{fname='Peter', lname='Fox'}, {fname='Alfred', lname='Hitchcock'}, {fname='Homer', lname='Simpson'}, {fname='Bart', lname='Simpson'}, null]
        System.out.println(ordering.nullsLast().sortedCopy(persons));

// order by last name descending, first name ascending
        ordering = ordering.reverse().compound(firstNameComparator);
        //[{fname='Bart', lname='Simpson'}, {fname='Homer', lname='Simpson'}, {fname='Alfred', lname='Hitchcock'}, {fname='Peter', lname='Fox'}, null]
        System.out.println(ordering.nullsLast().sortedCopy(persons));
    }
}
