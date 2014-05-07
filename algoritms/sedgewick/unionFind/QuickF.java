package algoritms.sedgewick.unionFind;

import algoritms.sedgewick.In;
import algoritms.sedgewick.Out;

/**
 * User: webserg
 * Date: 18.11.12
 * <p/>
 *
 * Suppose that we are given a sequence of pairs of integers, where each integer represents an object of some type and we are to
 * interpret the pair p-q as meaning "p is connected to q." We assume the relation "is connected to" to be transitive:
 * If p is connected to q, and q is connected to r, then p is connected to r. Our goal is to write a program to filter out
 * extraneous pairs from the set: When the program inputs a pair p-q, it should output the pair only if the pairs it has seen
 * to that point do not imply that p is connected to q.
 * If the previous pairs do imply that p is connected to q, then the program should ignore p-q and should proceed to input the next pair
 *
 *It is an implementation of a simple algorithm called the quick-find algorithm that solves the connectivity problem
 *  The basis of this algorithm is an array
 * of integers with the property that p and q are connected if and only if the pth and qth array entries are equal.
 * We initialize the ith array entry to i for 0  i < N. To implement the union operation for p and q, we go through the array,
 * changing all the entries with the same name as p to have the same name as q. This choice is arbitrary—we could have decided
 * to change all the entries with the same name as q to have the same name as p.
 */
public class QuickF {
    public static void main(String[] args) {
        int N = 9;
       slowImpl(N);
    }

    public static void slowImpl(int N){
        int id[] = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        for (In.init(); !In.empty(); ) {
            int p = In.getInt(), q = In.getInt();
            int t = id[p];
            if (t == id[q]) continue;
            for (int i = 0; i < N; i++)
                if (id[i] == t) id[i] = id[q];
            Out.println(" " + p + "" + q);
        }
    }
}
