package java8.lambda;

import java.util.*;
import java.util.function.Supplier;

public class MethodReferenceTest {

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

    public static void main(String... args) {

        List<Member> roster = new ArrayList<>();
        roster.add(
                new Member(
                        "Fred",
                        new GregorianCalendar(1980, 6, 20),
                        Member.Sex.MALE,
                        "fred@example.com"));
        roster.add(
                new Member(
                        "Jane",
                        new GregorianCalendar(1990, 7, 15),
                        Member.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Member(
                        "George",
                        new GregorianCalendar(1991, 8, 13),
                        Member.Sex.MALE, "george@example.com"));
        roster.add(
                new Member(
                        "Bob",
                        new GregorianCalendar(2000, 9, 12),
                        Member.Sex.MALE, "bob@example.com"));

        for (Member p : roster) {
            p.printMember();
        }


        Member[] rosterAsArray = roster.toArray(new Member[roster.size()]);

        class MemberAgeComparator implements Comparator<Member> {
            public int compare(Member a, Member b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Without method reference
        Arrays.sort(rosterAsArray, new MemberAgeComparator());

        // With lambda expression
        Arrays.sort(rosterAsArray,
                (Member a, Member b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        // With method reference
        Arrays.sort(rosterAsArray, Member::compareByAge);

        // Reference to an instance method of a particular object
        class ComparisonProvider {
            public int compareByName(Member a, Member b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Member a, Member b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);

        // Reference to an instance method
        // of an arbitrary object of a particular type

        String[] stringArray = {"Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda"};
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Set<Member> rosterSetLambda =
                transferElements(roster, () -> {
                    return new HashSet<Member>();
                });

        Set<Member> rosterSet = transferElements(roster, HashSet::new);
        System.out.println("Printing rosterSet:");
        rosterSet.stream().forEach(p -> p.printMember());
    }
}

