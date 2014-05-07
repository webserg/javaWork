package webserg.pazzlers.ch6;
/**
 * 
 * @author Sergiy Doroshenko
 *
 */
public class Null {
	/**
	 * 
	 */
	public static void green(){
		System.out.println("Hello world!");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		((Null) null).green();
		Null.green();
		if(null instanceof Null){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}

}
