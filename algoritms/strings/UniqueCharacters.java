package algoritms.strings;

import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 * <p>
 * Created by sergiy.doroshenko
 * Date: 7/26/11
 */
public class UniqueCharacters {
    public static void main(String[] args) {
        assert !allUniqueChars1("webserg");
        assert allUniqueChars1("sergiy");
        assert !allUniqueChars2("webserg");
        assert allUniqueChars2("sergiy");
    }

    public static final boolean allUniqueChars1(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) return false;
        }
        return true;
    }

    public static final boolean allUniqueChars2(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.lastIndexOf(s.charAt(i)) != i) return false;
        }
        return true;
    }
}
