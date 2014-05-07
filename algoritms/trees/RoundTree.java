package algoritms.trees;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RoundTree {
	public static void main(String[] args) {
		Leaf D = new Leaf();
		D.new NoLeafBuilder("D");
		// System.out.println(D);
		Leaf E = new Leaf();
		E.new NoLeafBuilder("E");
		Leaf F = new Leaf();
		F.new NoLeafBuilder("F");
		Leaf B = new Leaf();
		B.new NoLeafBuilder("B");
		Leaf G = new Leaf();
		G.new NoLeafBuilder("G");
		Leaf C = new Leaf();
		C.new LeafBuilder("C", D, E, F);
		Leaf A = new Leaf();
		A.new LeafBuilder("A", B, C, G);
		//System.out.println(roamWidth(A));
		Queue<Leaf> fifo = new LinkedList<Leaf>();
		fifo.offer(A);
		fifo.offer(B);
		fifo.offer(C);
		while(!fifo.isEmpty()){
			System.out.println(fifo.poll());
		}
		LinkedList<Leaf> lifo = new LinkedList<Leaf>();
		lifo.addFirst(C);
		lifo.addFirst(B);
		lifo.addFirst(A);
		while(!lifo.isEmpty()){
			System.out.println(lifo.poll());
		}
		Queue<Leaf> fifo2 = new PriorityQueue<Leaf>();
		fifo2.offer(A);
		fifo2.offer(B);
		fifo2.offer(C);
		while(!fifo2.isEmpty()){
			System.out.println(fifo2.poll());
		}

	}

	static private Queue<Leaf> roamWidth(Leaf A) {
		Queue<Leaf> s = new LinkedList<Leaf>();
		Queue<Leaf> path = new LinkedList<Leaf>();
		s.add(A);
		// Queue<Leaf> brothers = new LinkedList<Leaf>();
		while (!s.isEmpty()) {
			Leaf p = s.peek();
			if (!p.getLeafs().isEmpty() && !path.contains(p.getLeafs().get(0))) {
				path.offer(p.getLeafs().get(0));
				s.offer(p.getLeafs().get(0));

			} else {
				s.poll();
				if (!s.isEmpty() && null != s.peek().getLeafs() && !s.peek().getLeafs().isEmpty())
					for (Leaf b : s.peek().getLeafs()) {
						path.offer(b);
						s.offer(b);
					}
			}
		}

		return path;
	}

}

class Leaf {
	private String name;

	private Leaf left;

	private Leaf middle;

	private Leaf right;

	private Leaf[] leafs = new Leaf[3];

	public Leaf() {
	}

	/*
	 * public Leaf(Builder<Leaf> builer) { Leaf tmp = builer.build(); this.name =
	 * tmp.name; this.left = tmp.left; this.right = tmp.right; this.middle =
	 * tmp.middle; this.leafs = tmp.leafs; }
	 */

	// ----------------------------------------
	public class LeafBuilder {
		public LeafBuilder(String n, Leaf l, Leaf m, Leaf r) {
			Leaf.this.setName(n);
			Leaf.this.setLeft(l);
			Leaf.this.leafs[0] = l;
			Leaf.this.setMiddle(m);
			Leaf.this.leafs[1] = m;
			Leaf.this.setRight(r);
			Leaf.this.leafs[2] = r;

		}

		/*
		 * public Leaf build() { return new Leaf(this); }
		 */
	}

	// -----------------------------------
	public class NoLeafBuilder {
		public NoLeafBuilder(String n) {
			Leaf.this.setName(n);
			Leaf.this.setLeft(null);
			Leaf.this.setRight(null);
			Leaf.this.setMiddle(null);
		}
		/*
		 * public Leaf build() { return new Leaf(this); }
		 */
	}

	public Leaf getLeft() {
		return left;
	}

	public void setLeft(Leaf left) {
		this.left = left;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Leaf getRight() {
		return right;
	}

	public void setRight(Leaf right) {
		this.right = right;
	}

	public Leaf getMiddle() {
		return middle;
	}

	public void setMiddle(Leaf middle) {
		this.middle = middle;
	}

	public String toString() {
		return name;
	}

	public List<Leaf> getLeafs() {
		return Collections.unmodifiableList(new ArrayList<Leaf>(Arrays
				.asList(this.leafs)));
	}
}
