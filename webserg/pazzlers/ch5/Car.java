package webserg.pazzlers.ch5;

public class Car {
    private static Class clazzClass = Clazz.class;
    private Clazz clazz = (Clazz) clazzClass.newInstance();

    public Car() throws Exception {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
