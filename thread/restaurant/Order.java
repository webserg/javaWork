package thread.restaurant;

public class Order {
    private static int i = 0;
    private int count = i++;

    Order() {
        System.out.println("number of order is " + i);
        if (count == 10) {
            System.out.println("restaurant closed");
            System.exit(0);
        }

    }

}
