package collections;

import java.util.Iterator;
import java.util.List;
/**
 * (Given two vectors u1, . . . , un and v1, . . . , vn it computes u1 * v1 + · · · + un * vn.)
 * 
 * @author Sergiy Doroshenko webserg@gmail.com
 * Sep 12, 2010 1:32:45 PM
 */
public class SumOfVectors {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
    }

    public static double dot(List<Double> u, List<Double> v) {
        if (u.size() != v.size())
            throw new IllegalArgumentException("different sizes");
        double d = 0;
        Iterator<Double> u_it = u.iterator();
        Iterator<Double> v_it = v.iterator();
        while (u_it.hasNext()) {
            assert v_it.hasNext();
            d += u_it.next() * v_it.next();
        }
        assert !v_it.hasNext();
        return d;
    }
}
