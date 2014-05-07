package java8.lambda;

import java.io.File;
import java.util.*;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Any lambda expression may be thought of as an anonymous representation of a function descriptor of a functional
 * interface. An alternative way representing a function descriptor is with a concrete method of an existing class.
 * Method references are handles to such existing methods.
 * Notice that the syntax ReferenceType::Identifier used to reference static methods as in
 * the examples above can be used to reference instance methods also.
 */
public class MethodReferencesUsing {
    // The method transferElements copies elements from one collection to
    // another

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] iss = new Integer[]{1,2,3,4,7,8,0};
        Arrays.sort(iss, Integer::compare);

        //UnaryOperator<Integer> factorial = i -> { return i == 0 ? 1 : i * factorial.apply( i - 1 ); };

        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }

        Person[] rosterAsArray =
                roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator
                implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Without method reference
        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        // With lambda expression
        Arrays.sort(rosterAsArray,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        // With method reference
        Arrays.sort(rosterAsArray, Person::compareByAge);

        // Reference to an instance method of a particular object
        class ComparisonProvider {
            public int compareByName(Person a,
                                     Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a,
                                    Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);

        // Reference to an instance method
        // of an arbitrary object of a particular type

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Set<Person> rosterSetLambda =
                transferElements(roster, () -> { return new HashSet<>(); });

        Set<Person> rosterSet = transferElements(
                roster, HashSet::new);
        System.out.println("Printing rosterSet:");
        rosterSet.stream().forEach(p -> p.printPerson());
    }
}

