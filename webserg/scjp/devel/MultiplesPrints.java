package webserg.scjp.devel;

/**
 * Program prints from 1 to 100
 * but for multiples of 3 print fizz
 * for multiples of 5 buzz
 * for multiples of both print FizzBuzz
 *
 * @author Sergiy Doroshenko
 *         email:webserg@gmail.com
 *         Date: 1/14/11 11:37 AM
 */
public class MultiplesPrints {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }
}
