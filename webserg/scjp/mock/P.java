package webserg.scjp.mock;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pattern p = Pattern.compile("x*y");
        Matcher m = p.matcher("xxxy");
        System.out.println(m.matches());
        //FileWriter
        Locale l = new Locale("", "");
        //Object
        long bits = Double.doubleToLongBits(3.0);
        int h = 31 * 7 + (int) (bits * (bits >>> 32));
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        String[] s = list.toArray(new String[0]);
        System.out.println(new Double(1).equals(new P()));
        //LinkedHashSet
        //Collections.max
        Map map = new HashMap();
//		for(Map.Entry pp : map.entrySet()){
//			System.out.println(pp.getKey() +""+  pp.getValue());
//		}


    }


}
