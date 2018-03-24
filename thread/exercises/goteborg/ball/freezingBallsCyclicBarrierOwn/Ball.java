package thread.exercises.goteborg.ball.freezingBallsCyclicBarrierOwn;

import thread.exercises.goteborg.ball.init.BallI;
import thread.exercises.goteborg.ball.init.BallWorld;

import java.awt.*;
import java.util.concurrent.Semaphore;

public class Ball extends Thread implements BallI {

    private final static int ballw = 10;
    private final static int ballh = 10;
    private final Color col;
    private final Semaphore mutex = new Semaphore(0);
    private final MyCyclicBarrierI barrier;
    BallWorld<Ball> world;
    private int xpos, ypos, xinc, yinc;

    public Ball(BallWorld world, int xpos, int ypos,
                int xinc, int yinc, Color col, MyCyclicBarrierI _barrier) {
        //
        // Assign a name to this thread for easier debugging
        //
        super("Ball :" + col);

        this.world = world;
        this.xpos = xpos;
        this.ypos = ypos;
        this.xinc = xinc;
        this.yinc = yinc;
        this.col = col;
        this.barrier = _barrier;

        world.addBall(this);
    }

    public void run() {
        while (true) {
            if (xpos == ypos) {
                System.out.println("freez" + col.toString() + " " + xpos + " " + ypos);
                world.repaint();
                barrier.await();
            }
            move();
        }

    }

    public void move() {
        if (xpos >= world.getWidth() - ballw || xpos <= 0) xinc = -xinc;

        if (ypos >= world.getHeight() - ballh || ypos <= 0) yinc = -yinc;

        Balls.nap(30);
        doMove();
        world.repaint();
    }

    //
    // SYNC: This modifies xpos and ypos.
    //
    public synchronized void doMove() {
        xpos += xinc;
        ypos += yinc;
    }

    //
    // SYNC: This is accessed from the GUI thread, and
    //       it reads xpos and ypos.
    //
    public synchronized void draw(Graphics g) {
        g.setColor(col);
        g.fillOval(xpos, ypos, ballw, ballh);
    }

    public synchronized void unFreeze() {
        System.out.println("unfreez" + col);
        mutex.release();
        world.repaint();
    }
}
