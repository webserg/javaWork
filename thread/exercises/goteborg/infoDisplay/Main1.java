package thread.exercises.goteborg.infoDisplay;
/*
* http://www.cse.chalmers.se/edu/year/2012/course/TDA382_Concurrent_Programming_2012-2013_LP1/exercises/1/
* */
public class Main1 {

    private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        HWDisplay d = new JDisplay();

        d.write(5, 2, 'A');
        d.write(8, 11, 'B');
        nap(3000);
        d.write(5, 2, ' ');

    }
}