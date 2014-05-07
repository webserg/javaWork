package webserg.refactoring.ch1;
/**
 *  @author Sergiy Doroshenko;
 *  pattern State/Strategy for figure out rental of
 *  movie independently from movie type
 *  
 */
abstract class Price {
	abstract int priceCode();

	/**
	 * @param daysRented
	 *            int
	 * @return
	 */
	abstract double getCharge(final int daysRented);

	/**
	 * 
	 * @param daysRented
	 *            
	 * @return
	 */
	int getFrequentRenterPoints(final int daysRented) {
		return 1;
	}
}
