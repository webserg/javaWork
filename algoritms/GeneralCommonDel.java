package algoritms;

public class GeneralCommonDel {
    
   public static int gcd(int n, int m){
      int r;
        if (n > m)
            m = n;
        while (true) {
            r = m % n;
            if (r == 0)
                break;
            m = n;
            n = r;

        }
       return n; 
    }
   
   static int gcd2(int i, int j) {
       int t;
       while (i != 0) {
           if (j >= i)
               j -= i;
           else {
               t = i;
               i = j;
               j = t;
           }
       }
       return j;
   }
    
	public static void main(String[] argv) {
		int m = 544;
		int n = 119;
		
	  System.out.println("n = " + gcd(n,m));
      System.out.println("n = " + gcd2(8,3));

	}
}
