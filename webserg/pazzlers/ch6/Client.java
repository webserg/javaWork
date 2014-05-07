package webserg.pazzlers.ch6;
/**
 * @author Sergiy Doroshenko
 */
public class Client {
	/**
	 * @param args
	 */
	public static void main(final String[] args) {
        System.out.println(Cache.getSum());
        System.out.println(CacheFix.getSum());
		//System.out.println(StaticTest.k);
    }
}
