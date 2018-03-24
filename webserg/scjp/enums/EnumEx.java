package webserg.scjp.enums;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:39:57 PM
 */
public class EnumEx {
    public static void main(String[] argv) {
        Enumeration.Letters l;
        l = Enumeration.Letters.A;
        System.out.println(Enumeration.Letters.B.getK());
        //System.out.println(Enumeration.Letters.B.get());//Error!!! get invisible

    }
}

class Enumeration {
    enum Letters {
        A(0), C(2), D(3), B(1) {
            int getK() {
                return 0;
            }

            public void get() {
                System.out.println("get");
            }
        };

        private int k;

        Letters(int k) {
            this.k = k;
        }

        int getK() {
            return k;
        }
    }
}