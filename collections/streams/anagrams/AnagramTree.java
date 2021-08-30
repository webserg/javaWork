package collections.streams.anagrams;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Consider the following program, which reads the words from a dictionary file
 * and prints all the anagram groups whose size meets a user-specified minimum.
 * Recall that two words are anagrams if they consist of the same letters in a
 * different order. The program reads each word from a user-specified dictionary
 * file and places the words into a map. The map key is the word with its letters
 * alphabetized, so the key for "staple" is "aelpst", and the key for
 * "petals" is also "aelpst": the two words are anagrams, and all anagrams
 * share the same alphabetized form (or alphagram, as it is sometimes known). The
 * map value is a list containing all of the words that share an alphabetized form.
 * After the dictionary has been processed, each list is a complete anagram group.
 * The program then iterates through the map’s values() view and prints each
 * list whose size meets the threshold:
 * <p>
 * One step in this program is worthy of note. The insertion of each word into the
 * map, which is shown in bold, uses the computeIfAbsent method, which was
 * added in Java 8. This method looks up a key in the map: If the key is present, the
 * <p>
 * method simply returns the value associated with it. If not, the method computes
 * a value by applying the given function object to the key, associates this value
 * with the key, and returns the computed value. The computeIfAbsent method
 * simplifies the implementation of maps that associate multiple values with each
 * key.
 */
public class AnagramTree {
    public static void main(String[] args) throws IOException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
