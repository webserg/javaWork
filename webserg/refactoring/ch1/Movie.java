package webserg.refactoring.ch1;

/**
 * From book: 'Refactoring' by Martin Fowler This is the original code before
 * refactoring begins
 */

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;

    private String _title;
    private Price _price;

    /**
     * @param title
     * @param priceCode
     */
    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    /**
     * @return price
     */
    public int getPriceCode() {
        return this._price.priceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                this._price = new RegularPrice();
                break;
            case CHILDRENS:
                this._price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                this._price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

    /**
     * @param daysRented int
     * @return
     */
    double getCharge(final int daysRented) {
        return _price.getCharge(daysRented);
    }

    /**
     * @param daysRented TODO
     * @return
     */
    int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }

}
