package collections;

import java.util.*;

/**
 * Item 47 Bloch
 * For example, suppose you
 * want to return the power set of a given set, which consists of all of its subsets.
 * The power set of {a, b, c} is {{}, {a}, {b}, {c}, {a, b}, {a, c}, {b, c}, {a, b, c}}.
 * If a set has n elements, its power set has 2n. Therefore, you shouldn’t even
 * consider storing the power set in a standard collection implementation. It is,
 * however, easy to implement a custom collection for the job with the help of
 * AbstractList.
 * The trick is to use the index of each element in the power set as a bit vector,
 * where the nth bit in the index indicates the presence or absence of the nth
 * element from the source set. In essence, there is a natural mapping between the
 * binary numbers from 0 to 2n − 1 and the power set of an n-element set. Here’s
 * the code:
 */
public class PowerSet {
    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if (src.size() > 30)
            throw new IllegalArgumentException("Set too big " + s);
        return new AbstractList<Set<E>>() {
            @Override
            public int size() {
                return 1 << src.size(); // 2 to the power srcSize
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }

            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1)
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                return result;
            }
        };

    }

    public static void main(String[] args) {
        System.out.println(PowerSet.of(Set.of("a", "b", "c")));
    }
}