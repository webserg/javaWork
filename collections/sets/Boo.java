package collections.sets;

public class Boo implements Comparable<Boo>{
	String name;
	public Boo(String n){
		name = n;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Boo){
			if(this == obj) return true;
			return name.equals(((Boo)obj).name);
		}	
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	public int compareTo(Boo o) {
		return name.compareTo(o.name);
	}
	
	public void test(A a){
		System.out.println("foo");
	}
	@Override
	public String toString() {
		return name;
	}
	
}
class Boo2 extends Boo{
	Boo2(){
		super("");
	}
	public void test(A a) {
		System.out.println("f002");
	}
	
}

class A{}
class B extends A{}
