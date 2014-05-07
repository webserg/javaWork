package webserg.pazzlers.ch7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


public class SuspiciousSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rnd  = new Random();
		Integer[] arr = new Integer[100];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt();
		}
		/**
		 * don't use a subtraction-based comparator
		 * beware of int overflow 
		 */
		Comparator<Integer> cmp = new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;//don't use a subtraction-based comparator
				// better way 
				//return (i2 < i1 ? -1 : i2 == i1 ? 0 : 1)
			}
		};
		//Arrays.sort(arr,cmp);
		Arrays.sort(arr,Collections.reverseOrder());// if you have standart object like Integer
		System.out.println(order(arr));
		
	}
	
	enum Order{ASCENDING,DESCENDING,CONSTANT,UNORDERED};
	
	static Order order(Integer[] a){
		boolean ascending  = false;
		boolean descending = false;
		for (int i = 1; i < a.length; i++) {
			ascending |= (a[i] > a[i-1]);
			descending |= (a[i] < a[i-1]);
		}
		if(ascending && !descending)
			return Order.ASCENDING;
		if(descending && !ascending)
			return Order.DESCENDING;
		if(!ascending)
			return Order.CONSTANT;
		return Order.UNORDERED;
	}

}
