package webserg.scjp.string;

public class Polish {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int x = 4;
        StringBuffer sd = new StringBuffer("..fedcba");
        sd.delete(3, 6);
        sd.insert(3, "az");
        if (sd.length() > 6) x = sd.indexOf("b");
        sd.delete((x - 3), (x - 2));
        System.out.println(sd);

    }

}
