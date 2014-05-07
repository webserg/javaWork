package algoritms;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Sergiy Doroshenko
 */
public class MergeSort extends TestCase {

    private static int[] source;
    private static long inversions;
    


    public void testQuickSort() {
        System.out.println("start");
        final int result[] = new int[] { 1, 2, 3, 4, 5, 6,7,8,9};
        
        //source = ShuffleArray.shuffle(new int[] { 1, 2, 3, 4, 5, 6, 7, 8,9});
        source = new int[] { 9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(source));
        assertFalse(Arrays.equals(result, source));
        mergeSort(source);
        System.out.println(Arrays.toString(source));
        System.out.println(inversions);
        assertTrue(Arrays.equals(result, source));
    }

    /**
     * @param s array
     */
    public void mergeSort(int[] s) {    
        split(s);
    }

    private static void split(int[] s) {
        final int n = s.length;
        if (n < 2)
            return;
        int m = n/2;
        int[] s1 = new int[m];
        int[] s2;
        if( 2*m == n)
            s2 = new int[m];
        else s2 = new int[m+1];
        for (int i = 0; i < m; i++) {
            s1[i] = s[i];
        }
        for (int i = m,k=0; i < n ; i++,k++) {
            s2[k] = s[i];
        }
        split(s1);
        split(s2);
        merge(s1,s2,s);
    }

    private static void merge(int[] s1,int[] s2,int[] s) {
       int i=0; 
       int firstS1=0;
       int firstS2=0;
       while(s1.length > firstS1 && s2.length > firstS2 ){
           if(s1[firstS1] < s2[firstS2]){
               s[i] = s1[firstS1];
               firstS1++;
           }    
           else{
               s[i] = s2[firstS2];
               firstS2++;
               inversions++;
           }
           i++;
       }
       while(s1.length > firstS1){
           s[i] = s1[firstS1];
           i++;
           firstS1++;
           inversions++;
       }
       while(s2.length > firstS2){
           s[i] = s2[firstS2];
           i++;
           firstS2++;
           //inversions++;
       }
    }

}
