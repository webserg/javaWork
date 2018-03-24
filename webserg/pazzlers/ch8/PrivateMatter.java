package webserg.pazzlers.ch8;

public class PrivateMatter {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Derived().className);
        System.out.println(new Derived().getClassname());
    }

}

