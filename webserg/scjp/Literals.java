package webserg.scjp;


public class Literals {

    public static void main(String[] argv) {
        long so = 0xFl;
        System.out.println(so);
        char c = (char) -123;
        System.out.println((int) c);
        byte b1 = 6;
        byte b2 = 5;
        byte b3 = (byte) (b1 + b2);//result of b1+b2 will be int always
        b1 = 11;
        System.out.println(b3);

        int i = 100;
        long l = i;//implicit cast

        float f = 100.01f;
        int ifl = (int) f;//explicit cast
        System.out.println(ifl);

        int x = (int) 328.99;
        System.out.println(x);

        long l2 = 130l;
        byte bl2 = (byte) l2;
        System.out.println(bl2);

        float f2 = 32.3F;

        byte b4 = (byte) 127;
        System.out.println(b4);

        byte b5 = 3;
        b5 += 7;
        System.out.println(b5);
        byte b6 = 3;
        b6 = (byte) (b6 + 7);
        char c2 = (char) (65535);
        System.out.println(c2);
        char c3 = (char) (65535 + 1);
        System.out.println(c3);


    }

}

