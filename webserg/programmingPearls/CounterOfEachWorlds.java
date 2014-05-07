package webserg.programmingPearls;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.TestCase;

/**
 * @author Sergiy Doroshenko problem is to count the number of times each word occurs in the
 *         document
 */
public class CounterOfEachWorlds extends TestCase {

    static Logger log = Logger.getLogger(CounterOfEachWorlds.class.getName());

    static int NHASH = 29989;

    static Node[] bin = new Node[NHASH];

    private static class Node {

        String word;

        int count;

        Node next;

        @Override
        public int hashCode() {
            return word.hashCode() % NHASH < 0 ? word.hashCode() % NHASH * -1 : word.hashCode() % NHASH;
        }
    }

    private static void getListOfWorlds(String fileName) {
        File inFile = new File(fileName);
        if (inFile.exists()) {
            try {
                Scanner scanner = new Scanner(inFile);
                while (scanner.hasNext()) {
                    countWords(scanner.next());
                }
            } catch (IOException e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    private static void countWords(final String s) {
        Node nextNode = new Node();
        nextNode.word = s;
        nextNode.count = 1;
        int hash = nextNode.hashCode();
        Node node = bin[hash];
        if (node != null) {
            do {
                if (node.word.equalsIgnoreCase(s)) {
                    node.count++;
                    return;
                }
            } while (node.next != null);
            node.next = nextNode;

        } else {

            bin[hash] = nextNode;
        }

    }

    public void testCount() {
        String fileName = "worlds.txt";
        File file = new File(fileName);
        String inWords = "in in the the two twenty";

        try {
            Writer writer = new FileWriter(file);
            writer.write(inWords);
            writer.close();
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        getListOfWorlds(fileName);
        for (int i = 0; i < NHASH; i++)
            for (Node n = bin[i]; n != null; n = n.next) {
                System.out.println(n.word + " = " + n.count + ";" + n.hashCode());
            }
    }
    /**
     * 
     */
    /* public void testGetWorlds() {
         String fileName = "worlds.txt";
         File file = new File(fileName);
         String inWords = "This little exercise illustrates the two main ways to represent sets of words. Balanced search trees operate on strings"
                 + "as indivisible objects; these structures are used in most implementations of the STL sets and maps. They always "
                 + "keep the elements in sorted order, so they can efficiently perform operations such as finding a predecessor "
                 + "or reporting the elements in order. Hashing, on the other hand, peeks inside the characters to compute a hash function, "
                 + "and then scatters keys across a big table. It is very fast on the average, but it does not offer the worst-case"
                 + "performance guarantees of balanced trees, or support other operations involving order.";
         try {
             Writer writer = new FileWriter(file);
             writer.write(inWords);
             writer.close();
         } catch (IOException e) {
             log.error(e);
         }
         String[] outWords = getListOfWorlds(fileName);
         Arrays.equals(inWords.split("\\s"), outWords);
     }*/
}
