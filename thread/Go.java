package thread;

public class Go {
	static Integer k=1;
	public static void main(String[] argv){
		Thread t1 = new Thread1(k,"first");
		Thread t2 = new Thread1(k,"second");
		//System.out.println("jump");
		//Thread t2 = new Thread2(k);
	}
}
