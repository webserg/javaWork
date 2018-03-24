package thread.exercises.goteborg.ball.freezingBalls;

import thread.exercises.goteborg.ball.init.BallWorld;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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

    public static void main(String[] a) {

        final BallWorld world = new BallWorld();
        final JFrame win = new JFrame();
        SwingUtilities.invokeLater(() -> {
            win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            win.getContentPane().add(world);
            win.pack();
            win.setVisible(true);
        });

        Thread.currentThread().setName("MyMainThread");
        Semaphore barrier = new Semaphore(4);
        try {
            barrier.acquire(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Ball> balls = new ArrayList<>();
        Ball red = new Ball(world, 50, 80, 5, 10, Color.red, barrier);
        red.start();
        balls.add(red);
        nap((int) (1000 * Math.random()));
        Ball blue = new Ball(world, 70, 100, 8, 6, Color.blue, barrier);
        blue.start();
        balls.add(blue);
        nap((int) (1000 * Math.random()));
        Ball green = new Ball(world, 150, 100, 9, 7, Color.green, barrier);
        green.start();
        balls.add(green);
        nap((int) (1000 * Math.random()));
        Ball black = new Ball(world, 200, 130, 3, 8, Color.black, barrier);
        black.start();
        balls.add(black);
        nap((int) (5000 * Math.random()));
        while (true) {
            while (barrier.availablePermits() < 4) {
                nap((int) (1000 * Math.random()));
            }
            nap((int) (1000 * Math.random()));
            try {
                barrier.acquire(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Ball b : balls) {
                b.unFreeze();
                nap((int) (100 * Math.random()));
            }
        }
    }
}
