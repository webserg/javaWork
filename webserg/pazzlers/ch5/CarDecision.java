package webserg.pazzlers.ch5;

public class CarDecision {

    private static Class clazzClass = Clazz.class;

    private Clazz clazz = newClazz();

    public CarDecision() {
    }

    private static Clazz newClazz() {
        try {
            return (Clazz) clazzClass.newInstance();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new CarDecision();
    }
}
