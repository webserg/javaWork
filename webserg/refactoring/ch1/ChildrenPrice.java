package webserg.refactoring.ch1;

class ChildrenPrice extends Price {

	@Override
	int priceCode() {
		return Movie.CHILDRENS;
	}
	@Override
	double getCharge(final int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}

}
