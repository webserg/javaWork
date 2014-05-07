package webserg.scjp.devel;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 1:40:16 PM
 */
class Raptor extends Bird {
    static {
        System.out.print("r1 ");
    }

    public Raptor() {
        System.out.print("r2 ");
    }

    {
        System.out.print("r3 ");
    }

    static {
        System.out.print("r4 ");
    }
}
