package crypt;

import algoritms.GeneralCommonDel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by webserg on 9/21/2016.
 */
public class TuringCodeGCD {
    public static void main(String[] args) {
        int k = 13;
        System.out.println("message m1=" + word2Int("victor"));
        long c1 = word2Int("victory") * k;
        System.out.println("cypher c1=" + c1);
        System.out.println("message m2=" + word2Int("loosing"));
        long c2 = word2Int("loosing") * k;
        System.out.println("cypher c2=" + c2);
        System.out.println(GeneralCommonDel.gcd2(c1,c2));
    }

    public static Long word2Int(String str) {
        char[] ch = str.toCharArray();
        StringBuilder stringBuffer = new StringBuilder();
        for (char c : ch) {
            int temp = (int) c;
            int temp_integer = 96; //for lower case
            if (temp <= 122 & temp >= 97) {
                int i = temp - temp_integer;
                if(i<10){
                    stringBuffer.append("0");
                }
                stringBuffer.append(i);
            }
        }
        return Long.valueOf(stringBuffer.toString());
    }
}
