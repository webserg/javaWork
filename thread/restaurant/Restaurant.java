package thread.restaurant;

public class Restaurant {
    Order order;

    public static void main(String argv[]) {
        Restaurant restaurant = new Restaurant();
        WaitPerson1 waitPerson1 = new WaitPerson1(restaurant, 1);
        Chef chef = new Chef(waitPerson1, restaurant);

    }
}
