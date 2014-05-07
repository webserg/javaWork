package webserg.pazzlers.ch8;

public class Enigma {
	/*
	 * Don't do this!
	 * If two overloadings of the same method can applied to some parameter,
	 * they should have identical behavior.
	 * If you do overload a method, make sure that all overloading behave identically.
	 */
	public boolean equals(Enigma obj) {
		return false;
	}
}
