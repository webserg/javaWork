package webserg.pazzlers.ch8;

public class Heads extends CoinSide{
	private Heads(){}
	public static final Heads INSTANCE = new Heads();
	
	public String toString(){
		return "heads";
	}

}
