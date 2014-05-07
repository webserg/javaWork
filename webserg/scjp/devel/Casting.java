package webserg.scjp.devel;


public class Casting {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        System.out.println(i);
        int j = (int) 2147483659d;
        System.out.println(j);
        System.out.println("float = " + Float.MAX_VALUE);
        System.out.println("double = " + Double.MAX_VALUE);
        float f = (float) 214.0d;
        System.out.println(f);
        byte b = (byte) f;
        System.out.println(b);
        System.out.println("=========================");
        Short s = new Short((short) 7);
        if (new Short((short) 1000) < new Integer(1001)) System.out.println(s);
        //String
        //Object
        //Object[] o = new Object[]{new Integer(1),new String("foo")};
        //Arrays.sort(o);

        byte bb = 1;
        bb += 129;
        System.out.println(bb);
    }
}
