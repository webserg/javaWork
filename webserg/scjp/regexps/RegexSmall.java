package webserg.scjp.regexps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexSmall {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d*");
        String s = "o12e45bt";
        Matcher m = p.matcher(s);
        boolean b = false;
        while (b = m.find()) {
            System.out.print(m.start() + "," + m.end() + " ");
            System.out.println(m.group());
        }

		/*String s2 = "ab5 ccc 45 55 @";
		String[] toks = s2.split("\\d");
		System.out.println(toks.length);
		for (String string : toks) {
			System.out.println(">" + string + "<");
		}*/
        //	File
    }
}
