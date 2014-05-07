package webserg.pazzlers.ch8;
/**
 * 
 * @author Sergiy Doroshenko
 * puzzle 68
 */
public class ShadesOfGray{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * when variable and a type have the same name and both are in the scope,
		 * the variable name takes precedes
		 * use code convention to avoid ambiguous call 
		 */
		//System.out.println( ((X.Y) null).Z);
		System.out.println(ZZ.Z);
		echo();
	}
	
	static <T extends X.Y> void echo(){
		System.out.println(T.Z);
	}
}

class X{
	static class Y{
		static String Z = "Black";
	}
	static C Y = new C();
}
class C{
	String Z = "White";
}
class ZZ extends X.Y{}