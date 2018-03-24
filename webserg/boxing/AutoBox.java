package webserg.boxing;

public class AutoBox {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer y = new Integer(567);
        int x = y.intValue();
        x++;
        y = new Integer(x);
        System.out.println(y);
        // another equal way
        Integer y2 = new Integer(567);
        y2++;
        System.out.println(y2);
        //-----------------------------------
        Integer i1 = 10;
        Integer i2 = 10;
        if (i1 != i2) System.out.println(i1 + " != " + i2);
        if (i1 == i2) System.out.println(i1 + " == " + i2);
        if (i1.equals(i2)) System.out.println(i1 + " equals " + i2);
        Integer i3 = 128;
        Integer i4 = 128;
        if (i3 != i4) System.out.println(i3 + " != " + i4);
        if (i3 == i4) System.out.println(i3 + " == " + i4);
        if (i3.equals(i4)) System.out.println(i3 + " equals " + i4);
        Integer inull = (Integer) null;
        System.out.println(inull);

        Boolean b = new Boolean("qwerty");
        System.out.println(b);
        Integer in = new Integer("");
        System.out.println(in);
        //----------------------------------------------
        byte bb = 1;
        char cc = 1;
        short ss = 1;
        int ii = 1;
        Character c = 'q';
        //Integer i = bb; // you can not wide than box
        Integer i = ii;//assign value of primitive to wrapper
        //Short sh  = c;
        //Short sh = Short.MAX_VALUE;//cast to int and autobox to new Short
        ii = i;

    }

}
