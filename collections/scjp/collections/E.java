package collections.scjp.collections;

public class E<E> {
	E(){System.out.println("E");}
	<E> E(E e){
		System.out.println("");
		System.out.println(e.getClass().getName());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//E e = new E(new E());
		new X();

	}

}
class X extends E{
	X(){
		super(new E<E>());
	}
}
