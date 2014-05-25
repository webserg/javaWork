package algoritms.sort;

import java.util.Arrays;

public class QuikeSort2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] s = new int[10];
		for (int i = 0; i < 10; i++) {
			s[i] = (int)(Math.random() * 100);
		}
		
		System.out.println(Arrays.toString(s));
		System.out.println("after");
		quikeSearch(s, 0, s.length - 1);
		System.out.println(Arrays.toString(s));
	}

	public static void quikeSearch(int[] s, int l, int r) {
		if (l >= r)	return;
		int p = s[r];
		int lx = l;
		int rx = r - 1;
		while(lx <= rx) {
			while (lx <= rx && s[lx] <= p) {
				lx++;
			}
			while (rx >= lx && s[rx] >= p) {
				rx--;
			}
			if (lx < rx) {
				int tmp = s[lx];
				s[lx] = s[rx];
				s[rx] = tmp;
				System.out.println(Arrays.toString(s));
			}
		}
		{
		int tmp = s[lx];
		s[lx] = s[r];
		s[r] = tmp;
		System.out.println(Arrays.toString(s));
		}
		
		quikeSearch(s, l,lx-1);
		quikeSearch(s, lx+1, r);
		
	}
}
