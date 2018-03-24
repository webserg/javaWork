package webserg.refactoring.ch1;

import java.util.Enumeration;
import java.util.Vector;

//From book: 'Refactoring' by Martin Fowler
//This is the original code before refactoring begins

/**
 *
 */
public class Customer {

    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    /**
     * @param name
     */
    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    /**
     * figure out ASCII version of statment
     *
     * @return result
     */
    public String statement() {
        Enumeration<Rental> rentals = this._rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";

        return result;
    }

    /**
     * figure out HTML version of statment
     *
     * @return result
     */
    public String htmlStatement() {
        Enumeration<Rental> rentals = this._rentals.elements();
        String result = "<H1>Operations of rental for " + getName() + "</H1>";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getMovie().getTitle() + ":"
                    + String.valueOf(each.getCharge()) + "<br>";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "<br>\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    /**
     * @return
     */
    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
