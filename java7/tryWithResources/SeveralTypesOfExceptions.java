package java7.tryWithResources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sergiy.doroshenko
 * Date: 10/13/11
 * <p/>
 * Handling More Than One Type of Exception
 * In Java SE 7 and later, a single catch block can handle more than one type of exception.
 * This feature can reduce code duplication and lessen the temptation to catch an overly broad exception.
 * <p/>
 * Consider the following example, which contains duplicate code in each of the catch blocks:
 * <p/>
 * catch (IOException ex) {
 * logger.log(ex);
 * throw ex;
 * catch (SQLException ex) {
 * logger.log(ex);
 * throw ex;
 * }
 * In releases prior to Java SE 7, it is difficult to create a common method to eliminate the duplicated code because the
 * variable ex has different types.
 * <p/>
 * The following example, which is valid in Java SE 7 and later, eliminates the duplicated code:
 * <p/>
 * catch (IOException|SQLException ex) {
 * logger.log(ex);
 * throw ex;
 * }
 * The catch clause specifies the types of exceptions that the block can handle, and each exception type is separated with a vertical bar (|).
 * <p/>
 * Note: If a catch block handles more than one exception type, then the catch parameter is implicitly final. In this example,
 * the catch parameter ex is final and therefore you cannot assign any values to it within the catch block.
 */
public class SeveralTypesOfExceptions {

    private final static Logger logger = Logger.getLogger(SeveralTypesOfExceptions.class.getName());

    public static void main(String[] args) {
        logger.setLevel(Level.INFO);
        try {
            if (1 == 1) {
                throw new IOException();
            } else throw new SQLException();
        } catch (IOException | SQLException ex) {
            logger.log(Level.INFO, ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
