package webserg.pazzlers.ch9;

public class Outer {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        new Outer().greenWorld();
    }

    public void greenWorld() throws Exception {
        //System.out.println(new Inner());
        System.out.println(Inner.class.newInstance());
        /*
         * method newInstance invoke constructor whithout parameters
         * but inner class dont have parameterless constructor implicitly
         * because implicitly inner class have constructor with link to
         * enclosing class as first parameter
         *
         */
    }

    //prefer static member over nonstatic
    public class Inner {
        public String toString() {
            return "Hello world";
        }
    }
}
