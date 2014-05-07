package webserg.refactoring.ch1;
/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	/**
	 * @param thisAmount
	 * @return
	 */
	double getCharge() {
		return _movie.getCharge(this.getDaysRented());
	}

	/**
	 * @return
	 */
	int getFrequentRenterPoints() {
		return _movie.getFrequentRenterPoints(this.getDaysRented());
	}
	
	
	
}
