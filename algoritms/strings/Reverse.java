package algoritms.strings;

/**
 * User: Sergiy Doroshenko
 * Date: Nov 15, 2010 12:30:17 PM
 */
public class Reverse {
    public static void main(String[] args) {
        String str = "abcdefgklmopqrstwz";
        assert "zwtsrqpomlkgfedcba".equals(reversBySwapBuffer(str));
        assert "zwtsrqpomlkgfedcba".equals(reverseByRecursion(str));
        assert "zwtsrqpomlkgfedcba".equals(reverseByRecursion2(str));
        assert "zwtsrqpomlkgfedcba".equals(reverseByCharArray(str));
        assert "zwtsrqpomlkgfedcba".equals(reverseByArray2(str));
        assert "zwtsrqpomlkgfedcba".equals(reverseByXor(str));
        // System.out.println(reverseByShift(str));


    }

    public static final String reversBySwapBuffer(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        StringBuffer buffer = new StringBuffer(str);
        for (int i = 0; i < buffer.length() / 2; i++) {
            int swapIndex = buffer.length() - 1 - i;
            char swapChar = buffer.charAt(swapIndex);
            buffer.setCharAt(swapIndex, buffer.charAt(i));
            buffer.setCharAt(i, swapChar);
        }
        return buffer.toString();
    }

    public static final String reverseByRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(str.charAt(str.length() - 1)).append(reverseByRecursion(str.substring(0, str.length() - 1)));
        return buffer.toString();
    }

    public static final String reverseByRecursion2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverseByRecursion(str.substring(1)) + str.charAt(0);
    }

    public static String reverseByCharArray(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] strArray = str.toCharArray();
        int len = strArray.length - 1;
        for (int i = 0; i <= len / 2; i++) {
            char t = strArray[i];
            strArray[i] = strArray[len - i];
            strArray[len - i] = t;
        }
        return new StringBuilder().append(strArray).toString();
    }

    public static String reverseByArray2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] strArray = new char[str.length()];
        int len = strArray.length - 1;
        for (int i = 0; i <= len; i++) {
            strArray[i] = str.charAt(len - i);
        }
        return new StringBuilder().append(strArray).toString();
    }

    /*
     * XOR - one or another, never neither or both
     * */
    public static String reverseByXor(String str) {
        // convert the string to char array
        char[] charArray = str.toCharArray();
        int len = str.length() - 1;
        /*
        now this for is a bit unconventional at first glance because there
        are 2 variables that we're changing values of: i++ and len--.
        the order of them is irrelevant. so basicaly we're going with i from
        start to end of the array. with len we're shortening the array by one
        each time. this is probably understandable.
        */
        for (int i = 0; i < len; i++, len--) {
            /*
            now this is the tricky part people that should know about it don't.
            look at the table below to see what's going on exactly here.
            */
            charArray[i] ^= charArray[len];
            charArray[len] ^= charArray[i];
            charArray[i] ^= charArray[len];
        }
        return new String(charArray);
    }
}
