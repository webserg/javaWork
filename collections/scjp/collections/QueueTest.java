package collections.scjp.collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<String>();
		q.add("aa");
		q.add("ff");
		q.add("bb");
		q.add("cc");
		System.out.println(q.peek());
		Iterator<String> it = q.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
	}

}
