package webserg.init;

public class Init {
    static {
        System.out.println("static");
    }

    /**
     * @param args
     */
    int x;

    public static void main(String[] args) {
        System.out.println("first");
        Init init = new Init();
        init.use();

    }

    void use() {
        int y;
        System.out.println("");
    }

}
