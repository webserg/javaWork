package algoritms.strings;

/**
 * User: Sergiy Doroshenko
 * Date: Nov 17, 2010 4:42:51 PM
 */
public class Shift {
    public static void main(String[] args) {
        String str = "abcdefgklmopqrstwz";
        System.out.println(reverseByShift(str));
        assert "defgklmopqrstwzabc".equals(reverseByShift(str));
    }

    public static final String reverseByShift(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] strArray = str.toCharArray();
        int len = strArray.length;
        int shift = 3;
        swap(strArray, 0, shift - 1);
        swap(strArray, shift, len - 1);
        swap(strArray, 0, len - 1);
        return new String(strArray);
    }

    private static void swap(char[] s, int i, int j) {
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}
