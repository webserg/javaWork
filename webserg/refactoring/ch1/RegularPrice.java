/**
 * 
 */
package webserg.refactoring.ch1;

/**
 * @author Sergiy Doroshenko
 * 
 */
class RegularPrice extends Price {

	/*
	 * (non-Javadoc)
	 * 
	 * @see webserg.refactoring.ch1.Price#priceCode()
	 */
	@Override
	int priceCode() {
		return Movie.REGULAR;
	}
	@Override
	double getCharge(final int daysRented) {
		double result = 2;
		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;
		return result;
	}

}
