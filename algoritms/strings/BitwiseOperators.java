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
        System.out.println(a | b); //0111  = 7 (In decimal) // Bitwise OR (|) –
        System.out.println(a & b); //0101  = 5 (In decimal)

        //This operator is a binary operator, denoted by ‘^’. It returns bit by bit XOR of input values, i.e,
        // if corresponding bits are different, it gives 1, else it gives 0.
        //For example,

        System.out.println(a ^ b); //0010  = 2 (In decimal)Bitwise XOR (^) –

//        Bitwise Complement (~) –
//        This operator is a unary operator, denoted by ‘~’. It returns the one’s complement representation of
//        the input value, i.e, with all bits inverted, which means it makes every 0 to 1, and every 1 to 0.
//        For example,
        System.out.println((~5));//~ 0101 == 1010  = 10 (In decimal)

        int n = 4;

        int res = 4 >>> 1;
        System.out.println("shift right 1 equals delition by 2, " + res);
        res = 4 << 1;
        System.out.println("shift left 1 equals multipl by 2, " + res);

        /**
         * Bitwise Left Shift Operator (<<)
         * Left shift operator shifts the bits of the number towards left a specified number of positions. The symbol for this operator is <<.
         * When you write x<<n, the meaning is to shift the bits of x towards left n specified positions.
         *
         * Example
         * If x=10, then calculate x<<2 value.
         *
         * Shifting the value of x towards the left two positions will make the leftmost 2 bits to be lost. The value of x is 10.
         * The binary representation of 10 is 00001010. The procedure to do left shift explained in the following example:
         *
         * Observe the above example, after shifting the bits to the left the binary number 00001010 (in decimal 10) becomes 00101000 (in decimal 40).
         *
         * Bitwise Right Shift Operator
         * The Right Shift Operator shifts the bits of the number towards right a specified n number of positions. Right shift
         * operator represented by the symbol >>, read as double greater than. When you write x>>n, the meaning is to shift the bits x towards the right n specified positions.
         *
         * >> shifts the bits towards the right and also preserve the sign bit, which is the leftmost bit. The leftmost bit represents
         * the sign of the number. The sign bit 0 represents a positive number, and 1 represents a negative number.
         * So after performing >> on a positive number, we get a positive value in the result also.
         * When we perform >> on a negative number, again we get a negative value.
         *
         * Example
         * If x=10, then calculate x>>2 value.
         *
         * Shifting the value of x towards the right two positions will make the rightmost 2 bits to be lost. The value of x is 10.
         * The binary representation of 10 is 00001010. The procedure to do right shift explained in the following example:
         *
         * Observe the above example, after shifting the bits to the right the binary number 00001010 (in decimal 10) becomes 00000010 (in decimal 2).
         *
         * Bitwise Zero Fill Right Shift Operator (>>>)
         * Bitwise Zero Fill Right Shift Operator shifts the bits of the number towards the right a specified n number of positions.
         * The sign bit filled with 0's. The symbol >>> represents the Bitwise Zero Fill Right Shift Operator.
         *
         * When we apply >>> on a positive number, it gives the same output as that of >>. It gives a positive number when we apply >>> on a negative number.
         * MSB is replaced by a 0.
         *
         * Observe the above example, after shifting the bits to the right the binary number 00100000 (in decimal 32) becomes 00000100 (in decimal 4).
         * The last three bits shifted out and lost.
         *
         * Difference between >> and >>> operator
         * Both >> and >>> are used to shift the bits towards the right. The difference is that the >> preserve the sign bit
         * while the operator >>> does not preserve the sign bit. To preserve the sign bit, you need to add 0 in the MSB.
         */

        byte x, y;
        x = 10;
        y = -10;
        System.out.println("Bitwise Left Shift: x<<2 = " + (x << 2));
        System.out.println("Bitwise Right Shift: x>>2 = " + (x >> 2));
        System.out.println("Bitwise Zero Fill Right Shift: x>>>2 = " + (x >>> 2));
        System.out.println("Bitwise Zero Fill Right Shift: y>>>2 = " + (y >>> 2));

    }
}
