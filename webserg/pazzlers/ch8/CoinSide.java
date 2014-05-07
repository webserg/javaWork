package webserg.pazzlers.ch8;

import java.util.Random;

public class CoinSide {
	private static Random rnd = new Random();
	public static CoinSide flip(){
		return rnd.nextBoolean() ? Heads.INSTANCE : Tails.INSTANCE;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(flip());

	}

}
