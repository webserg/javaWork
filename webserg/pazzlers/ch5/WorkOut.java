package webserg.pazzlers.ch5;

/**
 * @author Sergiy Doroshenko
 */
public class WorkOut {
    /**
     * @param args
     */
    public static void main(String[] args) {

        workHard();

        System.out.println("It's nap time.");

    }


    private static void workHard() {

        try {

            workHard();

        } finally {

            //workHard();
            System.out.println("finally");

        }

    }

}
