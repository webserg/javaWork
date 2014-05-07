package algoritms;

import java.util.LinkedList;

public class HanoyTowers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		Towers a = new Towers(n);
		Towers b = new Towers(0);
		Towers c = new Towers(0);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		task(n,a,b,c);
		
		System.out.println("after");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	public static void task(int n,Towers a,Towers b,Towers c){
		if(n==1){
			
			b.add(a.get());
			
		}else{
			
			task(n-1,a,c,b);
			task(1,a,b,c);
			task(n-1,c,b,a);
			
		}
	}
}

class Towers{
	private LinkedList<Integer> circles;
	int count;
	public Towers(int c){
		circles = new LinkedList<Integer>();
		for (count = c; count>0; count--) {
			circles.add(count);
		}
	}
	public void add(int i){
		if(!circles.isEmpty() && circles.getLast() < i )
			throw new IllegalArgumentException("");
		circles.addLast(i);
	}
	
	public int get(){
		return circles.removeLast();
	}
	
	public boolean isEmpty(){
		return circles.isEmpty();
	}
	
	@Override
	public String toString() {
		return circles.toString();
	}
}
