package webserg.pazzlers.ch8;

public class Derived extends Base{
	/*
	 * If the class declares a field with a certain name, then the declaration of that
		field is said to hide any and all accessible declarations of fields with the same
		name in superclasses, and superinterfaces of the class.
	 */
	private String classname = "Derived"; // avoid hiding
	/*
	 * hiding violates Liskov Substitution Principle. This principle says that everything you can do with a base class,
	 *  you can also do with a derived class
	 */
/**
 * 
 * @return
 */
	public String getClassname() {
		return classname;
	}
}
