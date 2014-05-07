package webserg.pazzlers.ch8;

public class Tails extends CoinSide{
	private Tails(){}
	public static final Tails INSTANCE = new Tails();
	
	
	public String toString() {
		return "tails";
	}

}
