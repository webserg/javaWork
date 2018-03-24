package algoritms;

import junit.framework.TestCase;

import java.util.*;

public class Anagrams extends TestCase {

    String[] s = {"pots", "stop", "tops", "wops", "dops"};

    static private Map<String, Integer> countAnagrams(String[] S) {
        Map<String, Integer> anagrams = new HashMap<String, Integer>();
        anagrams.put(S[0], 0);
        OUT:
        for (String s : S) {
            for (String an : anagrams.keySet()) {
                if (an.length() == s.length()) {
                    int flag = 0;
                    for (char c : s.toCharArray()) {
                        if (an.indexOf(c) > -1) flag++;
                        else break OUT;
                    }
                    if (flag == an.length())
                        anagrams.put(an, anagrams.get(an) + 1);
                }
            }

        }
        return anagrams;
    }

    static private Map<String, Integer> countAnagramsBently(String[] S) {
        Map<String, Integer> anagrams = new HashMap<String, Integer>();
        Set<String> anagramsSet = new HashSet<String>();

        String[] S2 = new String[S.length];
        int i = 0;
        for (String string : S) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String t = new String(chars);
            anagramsSet.add(t);
            S2[i++] = t;
        }
        for (String s : anagramsSet) {
            anagrams.put(s, 0);
        }
        for (String string : S2) {
            if (anagrams.containsKey(string))
                anagrams.put(string, anagrams.get(string) + 1);
        }

        return anagrams;
    }

    /**
     * *
     * <p/>
     * A multimap is like a Map but it can map each key to multiple values.
     * The Java Collections Framework doesn't include an interface for multimaps
     * because they aren't used all that commonly. It's a fairly simple matter to use a Map whose values
     * are List instances as a multimap. This technique is demonstrated in the next code example, which
     * reads a word list containing one word per line (all lowercase) and prints out all the anagram groups
     * that meet a size criterion. An anagram group is a bunch of words, all of which contain exactly the same
     * letters but in a different order. The program takes two arguments on the command line: (1) the name of
     * the dictionary file and (2) the minimum size of anagram group to print out. Anagram groups containing
     * fewer words than the specified minimum are not printed.
     * <p/>
     * There is a standard trick for finding anagram groups: For each word in the dictionary,
     * alphabetize the letters in the word (that is, reorder the word's letters into alphabetical order)
     * and put an entry into a multimap, mapping the alphabetized word to the original word. For example,
     * the word bad causes an entry mapping abd into bad to be put into the multimap. A moment's reflection
     * will show that all the words to which any given key maps form an anagram group. It's a simple matter
     * to iterate over the keys in the multimap, printing out each anagram group that meets the size constraint.
     */
    static private Map<String, Integer> countAnagramsMultiMap(final String[] input) {
        // Read words from file and put into a simulated multimap
        Map<String, List<String>> m = new HashMap<>();
        for (String word : input) {
            String alpha = alphabetize(word);
            List<String> l = m.get(alpha);
            if (l == null)
                m.put(alpha, l = new ArrayList<>());
            l.add(word);
        }
        Map<String, Integer> res = new HashMap<>();
        for (String key : m.keySet())
            res.put(key, m.get(key).size());
        return res;
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public void testAnagrams() {
        char[] chars = "pots".toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
        assertEquals(new Integer(3), countAnagrams(s).get("pots"));
        assertEquals(new Integer(3), countAnagramsBently(s).get("opst"));
        assertEquals(new Integer(3), countAnagramsMultiMap(s).get("opst"));
    }

}
