package webserg.pazzlers.ch8;

import webserg.pazzlers.ch8.library.Api;

public class ClientApi {
    private String myOwnField = "";

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api api = new Api();
        System.out.println(api.getField());
        System.out.println(api.getMyOwnField());
    }

}
