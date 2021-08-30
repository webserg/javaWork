package algoritms.strings;

/**
 * 0000
 * 0001
 * 0010
 * 0011
 * 0100
 * 0101
 * 0110
 * 0111
 * 1000
 * 1001
 * 1010
 * https://www.geeksforgeeks.org/bitwise-operators-in-java/
 */
public class BitwiseOperators {

    public static void main(String[] args) {

        int a = 5;// = 0101 (In Binary)
        int b = 7;// = 0111 (In Binary)
        System.out.println( a | b); //0111  = 7 (In decimal) // Bitwise OR (|) –
        System.out.println( a & b); //0101  = 5 (In decimal)

        //This operator is a binary operator, denoted by ‘^’. It returns bit by bit XOR of input values, i.e,
        // if corresponding bits are different, it gives 1, else it gives 0.
        //For example,

        System.out.println( a ^ b); //0010  = 2 (In decimal)Bitwise XOR (^) –

//        Bitwise Complement (~) –
//        This operator is a unary operator, denoted by ‘~’. It returns the one’s complement representation of
//        the input value, i.e, with all bits inverted, which means it makes every 0 to 1, and every 1 to 0.
//        For example,
        System.out.println((~5));//~ 0101 == 1010  = 10 (In decimal)
    }
}
