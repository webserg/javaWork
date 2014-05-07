package webserg.scjp.regexps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Greeedy {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String p = args[0];
        String s = args[1];
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            System.out.println(m.start() + " " + m.group());
        }

    }

}
