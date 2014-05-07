package webserg.refactoring.ch1;

class NewReleasePrice extends Price {
	@Override
	int priceCode() {
		return Movie.NEW_RELEASE;
	}

	@Override
	double getCharge(final int daysRented) {
		return daysRented * 3;
	}
	
	@Override
	int getFrequentRenterPoints(final int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}
