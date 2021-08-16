package algoritms;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * A Bloom filter is a space-efficient probabilistic data structure that is used to test whether an element is a member of a set.
 * For example, checking availability of username is set membership problem, where the set is the list of all registered username.
 * The price we pay for efficiency is that it is probabilistic in nature that means, there might be some False Positive results.
 * False positive means, it might tell that given username is already taken but actually it’s not.
 * Interesting Properties of Bloom Filters
 * <p>
 * Unlike a standard hash table, a Bloom filter of a fixed size can represent a set with an arbitrarily large number of elements.
 * Adding an element never fails. However, the false positive rate increases steadily as elements are added until all bits in the filter
 * are set to 1, at which point all queries yield a positive result.
 * Bloom filters never generate false negative result, i.e., telling you that a username doesn’t exist when it actually exists.
 * Deleting elements from filter is not possible because, if we delete a single element by clearing bits at indices generated by k
 * hash functions, it might cause deletion of few other elements. Example – if we delete “geeks” (in given example below)
 * by clearing bit at 1, 4 and 7, we might end up deleting “nerd” also Because bit at index 4 becomes 0 and bloom filter claims that
 * “nerd” is not present.
 *
 * h1(“geeks”) % 10 = 1
 * h2(“geeks”) % 10 = 4
 * h3(“geeks”) % 10 = 7
 *
 * Now we will set the bits at indices 1, 4 and 7 to 1 
 */
public class BloomFilterDemo {
    public static void main(String[] args) {

        // Create a Bloom Filter instance
        BloomFilter<CharSequence> blackListedIps = BloomFilter.create(Funnels.stringFunnel(), 10000);

        // Add the data sets
        blackListedIps.put("192.170.0.1");
        blackListedIps.put("75.245.10.1");
        blackListedIps.put("10.125.22.20");

        // Test the bloom filter
        System.out.println(blackListedIps.mightContain("75.245.10.1"));
        System.out.println(blackListedIps.mightContain("101.125.20.22"));
    }
}

