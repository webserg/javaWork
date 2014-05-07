package thread.exercises.goteborg.ball.killingBalls;

import thread.exercises.goteborg.ball.init.BallWorld;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;

public class Balls {

    public static void nap(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            //
            //  Print out the name of the tread that caused this.
            //
            System.err.println("Thread " + Thread.currentThread().getName() +
                    " throwed exception " + e.getMessage());
        }
    }

    public static void main(String[] a) throws InterruptedException {

        final BallWorld<Ball> world = new BallWorld<>();
        final JFrame win = new JFrame();
        SwingUtilities.invokeLater(() -> {
            win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            win.getContentPane().add(world);
            win.pack();
            win.setVisible(true);
        });

        Thread.currentThread().setName("MyMainThread");
        Semaphore live = new Semaphore(4);
        Semaphore die = new Semaphore(4);
        die.acquire(4);
        nap((int) (5000 * Math.random()));
        new Ball(world, 50, 80, 5, 10, Color.red, live, die).start();
        nap((int) (5000 * Math.random()));
        new Ball(world, 70, 100, 8, 6, Color.blue, live, die).start();
        nap((int) (5000 * Math.random()));
        new Ball(world, 150, 100, 9, 7, Color.green, live, die).start();
        nap((int) (5000 * Math.random()));
        new Ball(world, 200, 130, 3, 8, Color.black, live, die).start();
        nap((int) (15000 * Math.random()));
        while (live.availablePermits() > 0) {
        }
        for (int i = 0; i < 4; i++) {
            die.release();
            nap((int) (10000 * Math.random()));
        }
    }
}
