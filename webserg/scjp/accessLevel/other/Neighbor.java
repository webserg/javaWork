package webserg.scjp.accessLevel.other;

public class Neighbor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Child child = new Child();
        //int x = child.x;//error becouse protected member becomes private to any code outside the subclass
        //child.protectedParentMethod();// it works althought for methods
    }

}
