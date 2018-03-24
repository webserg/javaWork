package webserg.pazzlers.ch5;

public class HelloGoodbye {

    /**
     * @param args
     */
    public static void main(String[] args) {
		/*try {
			System.out.println("Hello World");
			System.exit(0);//the System.ecit method halts the execution of the current thread and all other dead in their tracks
		} finally {
			System.out.println("GoodBye world");
		}*/

        System.out.println("hello world");
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    @Override
                    public void run() {
                        System.out.println("GoodBye world");
                    }
                }
        );
        System.exit(0);//the System.ecit method halts the execution of the current thread and all other dead in their tracks
    }
}
