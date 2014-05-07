package thread.pazzels;

/**
 * The application should print out "Mares do eat oats." Is it guaranteed to always do this?
 * If not, why not? Would it help to change the parameters of
 * the two invocations of Sleep? How would you guarantee that all changes
 *  to message will be visible to the main thread?
 * http://download.oracle.com/javase/tutorial/essential/concurrency/QandE/answers.html
 *
 *
 * Solution: The program will almost always print out "Mares do eat oats." However, this result is not
 * guaranteed, because there is no happens-before relationship between "Key statement 1" and "Key statment 2".
 * This is true even if "Key statement 1" actually executes before "Key statement 2" — remember, a happens-before
 * relationship is about visibility, not sequence.

There are two ways you can guarantee that all changes to message will be visible to the main thread:

In the main thread, retain a reference to the CorrectorThread instance. Then invoke join on that instance before
 referring to message
Encapsulate message in an object with synchronized methods. Never reference message except through those methods.
Both of these techniques establish the necessary happens-before relationship, making changes to message visible.

A third technique is to simply declare message as volatile. This guarantees that any write to message
 (as in "Key statement 1") will have a happens-before relationship with any subsequent reads of message
 (as in "Key statement 2"). But it does not guarantee that "Key statement 1" will literally happen before
 "Key statement 2". They will probably happen in sequence, but because of scheduling uncertainities and the
 unknown granularity of sleep, this is not guaranteed.

Changing the arguments of the two sleep invocations does not help either, since this does nothing to guarantee
 a happens-before relationship
 * @author Sergiy Doroshenko
 *         email:webserg@gmail.com
 *         Date: 1/16/11 1:23 PM
 */
public class BadThread {
    static String message;

    private static class CorrectorThread extends Thread {

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            //Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[]) throws InterruptedException {
        (new CorrectorThread()).start();
        message = "Mares do not eat oats.";
        Thread.sleep(2000);
        //Key statement 2:
        System.out.println(message);
    }
}
