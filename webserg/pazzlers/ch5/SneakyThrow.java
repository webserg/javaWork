package webserg.pazzlers.ch5;

public class SneakyThrow {

    public static void sneakyThrow(Throwable t) {
//        Thread.currentThread().stop(t);
    }

    public static void test() {
        sneakyThrow(new MyCheckedException()); // does exactly what the throw statement does;!!!!
        // and adding throws to the method signature doesn't need!!!!!
    }

    public static void test2() throws MyCheckedException {
        throw new MyCheckedException();
    }

    public static void test3() {
        TigerThrower.sneakyThrow(new MyCheckedException());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //sneakyThrow(new IllegalArgumentException("throw"));
        //Exception t = new IllegalArgumentException("throw");
			/*test();
			try {
				test2();
			} catch (MyCheckedException e) {
				
				e.printStackTrace();
			}*/
        try {
            test3();
        } catch (Exception e) {
            System.out.println("this is my exception");
            //e.printStackTrace();
        }
    }
}

class MyCheckedException extends Exception {

} 
