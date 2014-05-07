package webserg.pazzlers.ch5;

public class CarDecision {

	private static Class clazzClass = Clazz.class;

	private Clazz clazz = newClazz();

	private static Clazz newClazz() {
		try {
			return (Clazz) clazzClass.newInstance();
		} catch (IllegalAccessException e) {
			throw new AssertionError(e);
		} catch (InstantiationException e) {
			throw new AssertionError(e);
		}
	}

	public CarDecision() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CarDecision();
	}
}
